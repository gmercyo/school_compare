package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.dto.AnswerWithData;
import com.makersacademy.schoolcompare.dto.NearbySchool;
import com.makersacademy.schoolcompare.dto.QuestionWithData;
import com.makersacademy.schoolcompare.dto.ReviewWithData;
import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.QuestionLike;
import com.makersacademy.schoolcompare.pojo.CalculateDistance;
import com.makersacademy.schoolcompare.pojo.FilterCriteria;
import com.makersacademy.schoolcompare.repository.UserRepository;
import com.makersacademy.schoolcompare.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class SchoolsController {

    @Autowired
    SchoolRepository repository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    QuestionLikeRepository questionLikeRepository;
    @Autowired
    UserRepository userRepository;

    private List<NearbySchool> getNearbySchools(School school) {
        List<School> schoolsOfType = repository.findByType(school.getType());
        return schoolsOfType.stream()
                .filter(nearbySchool -> !nearbySchool.getId().equals(school.getId())) // Exclude the school with the same ID
                .map(nearbySchool -> {
                    double distance = CalculateDistance.fromLatLng(
                            nearbySchool.getLatitude(),
                            nearbySchool.getLongitude(),
                            school.getLatitude(),
                            school.getLongitude());
                    return new NearbySchool(nearbySchool.getId(), nearbySchool.getName(), nearbySchool.getAddress(), distance);
                })
                .filter(nearbySchool -> nearbySchool.getDistance() <= 1.0)
                .sorted(Comparator.comparingDouble(NearbySchool::getDistance))
                .toList();
    }

    private void fetchAnswers(List<QuestionWithData> questions, Long currentUser) {
        questions.forEach(question -> {
            List<AnswerWithData> answers = answerRepository.findAnswersByRelevance(question.getQuestion().getId(), currentUser);
            LocalDateTime lastAnswerTimestamp = answers.isEmpty()
                    ? null
                    : answers.stream()
                    .map(AnswerWithData::getCreatedAt)
                    .max(LocalDateTime::compareTo)
                    .orElse(null);

            question.setLastAnswerTimestamp(lastAnswerTimestamp);
            question.setAnswers(answers);
        });
    }

    @GetMapping("schools/{id}")
    public ModelAndView showSchoolInfo(
            @PathVariable("id") Long id,
            @RequestParam(value = "view", defaultValue = "questions") String view,
            @RequestParam(value = "sort_by", defaultValue = "relevance") String sortBy,
            HttpSession session) {

        ModelAndView model = new ModelAndView("/schools/show");
        Optional<School> schoolOpt = repository.findById(id);
        if (schoolOpt.isEmpty()) {
            model.addObject("error", "School not found");
            return model;
        }
        School school = repository.findById(id).orElseThrow();
        Long currentUser = (Long) session.getAttribute("userId");

        ReviewWithData topReview = reviewRepository.findTopReview(school.getId(), currentUser);

        model.addObject("school", school);
        model.addObject("view", view);
        model.addObject("sortBy", sortBy);
        model.addObject("nearbySchools", getNearbySchools(school));
        model.addObject("topReview", topReview);


        if (view.equals("questions")) {
            List<QuestionWithData> questions = questionRepository.findQuestionsBySchoolId(school.getId(), currentUser);
            questions.forEach(q -> {
                AnswerWithData bestAnswer = answerRepository.findBestAnswerByQuestionId(q.getId());
                q.setBestAnswer(bestAnswer);
            });

            fetchAnswers(questions, currentUser);

            if (sortBy.equals("relevance")) {
                questions.sort(Comparator.comparingLong(QuestionWithData::getLikes).reversed());
            } else if (sortBy.equals("recent")) {
                questions.sort(Comparator.comparing(QuestionWithData::getQuestion, Comparator.comparing(Question::getCreatedAt)).reversed());
            }
            model.addObject("questions", questions);

            if (currentUser != null) {
                List<QuestionLike> likedQuestions = questionLikeRepository.findByUserId(currentUser);
                List<Long> likedQuestionIds = likedQuestions.stream()
                        .map(QuestionLike::getQuestionId)
                        .collect(Collectors.toList());
                model.addObject("likedQuestionIds", likedQuestionIds);
            }
        }else if (view.equals("reviews")) {
            List<ReviewWithData> reviews = sortBy.equals("relevance")
                    ? reviewRepository.findReviewsByRelevance(school.getId(), currentUser)
                    : reviewRepository.findReviewsByRecent(school.getId(), currentUser);
            model.addObject("reviews", reviews);
        }

        return model;
    }

    @PostMapping(value = "/schools/api")
    @ResponseBody
    public ResponseEntity<List<School>> getSchools(@RequestBody FilterCriteria filterCriteria) {
        List<School> filteredSchools = repository.findSchoolsByFilterCriteria(
                filterCriteria.getAges(),
                filterCriteria.getGender(),
                filterCriteria.getRating(),
                filterCriteria.getAffiliation());
        return ResponseEntity.ok(filteredSchools);
    }

}
