package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.dto.AnswerWithData;
import com.makersacademy.schoolcompare.dto.NearbySchool;
import com.makersacademy.schoolcompare.dto.QuestionWithData;
import com.makersacademy.schoolcompare.dto.ReviewWithData;
import com.makersacademy.schoolcompare.model.*;
import com.makersacademy.schoolcompare.pojo.CalculateDistance;
import com.makersacademy.schoolcompare.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.makersacademy.schoolcompare.pojo.FilterCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

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
    UserRepository userRepository;
    @Autowired
    SchoolLikeRepository schoolLikeRepository;

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
                .filter(nearbySchool -> nearbySchool.getDistance() <= 0.8)
                .sorted(Comparator.comparingDouble(NearbySchool::getDistance))
                .toList();
    }

    private void fetchAnswers(List<QuestionWithData> questions, Long currentUser) {
        questions.forEach(question -> {
            List<AnswerWithData> answers = answerRepository.findAnswersByRelevance(question.getQuestion().getId(), currentUser);
            LocalDateTime lastAnswerTimestamp = answers.isEmpty()
                    ? null
                    : answers.stream()
                    .map(AnswerWithData::getAnswer)
                    .map(Answer::getCreatedAt)
                    .max(LocalDateTime::compareTo)
                    .orElse(null);

            question.setLastAnswerTimestamp(lastAnswerTimestamp);
            question.setAnswers(answers);
        });
    }

    private double getDistanceFromUser(School school, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return CalculateDistance.fromLatLng(
                user.getLatitude(),
                user.getLongitude(),
                school.getLatitude(),
                school.getLongitude());
    }

    @GetMapping("schools/{id}")
    public ModelAndView showSchoolInfo(
            @PathVariable("id") Long id,
            @RequestParam(value = "view", defaultValue = "questions") String view,
            @RequestParam(value = "sort_by", defaultValue = "relevance") String sortBy,
            HttpSession session) {
        ModelAndView model = new ModelAndView("/schools/show");
        School school = repository.findById(id).orElseThrow();
        Long currentUser = (Long) session.getAttribute("userId");
        ReviewWithData topReview = reviewRepository.findTopReview(school.getId(), currentUser);
        boolean schoolLikedByCurrentUser = schoolLikeRepository.isLikedByCurrentUser(school.getId(), currentUser);

        model.addObject("view", view);
        model.addObject("sortBy", sortBy);
        model.addObject("school", school);
        model.addObject("nearbySchools", getNearbySchools(school));
        model.addObject("topReview", topReview);
        model.addObject("userId", currentUser);
        model.addObject("schoolLikedByCurrentUser", schoolLikedByCurrentUser);

        if (currentUser != null) model.addObject("distanceFromUser", getDistanceFromUser(school, currentUser));

        if (view.equals("questions")) {
            List<QuestionWithData> questions = questionRepository.findQuestionsBySchoolId(school.getId(), currentUser);
            fetchAnswers(questions, currentUser);
            if (sortBy.equals("relevance")) {
                questions.sort(Comparator.comparingLong(QuestionWithData::getLikes).reversed());
            } else if (sortBy.equals("recent")) {
                questions.sort(Comparator.comparing(QuestionWithData::getQuestion, Comparator.comparing(Question::getCreatedAt)).reversed());
            }
            model.addObject("questions", questions);
            model.addObject("newQuestion", new Question());
            model.addObject("newAnswer", new Answer());
        } else if (view.equals("reviews")) {
            List<ReviewWithData> reviews = List.of();

            if (sortBy.equals("relevance")) {
                reviews = reviewRepository.findReviewsByRelevance(school.getId(), currentUser);
            } else if (sortBy.equals("recent")) {
                reviews = reviewRepository.findReviewsByRecent(school.getId(), currentUser);
            }
            model.addObject("reviews", reviews);
            model.addObject("newReview", new Review());
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

    @GetMapping("/profile")
    public ModelAndView userProfile(HttpSession session,
                                    @AuthenticationPrincipal DefaultOidcUser principal,
                                    @RequestParam(value = "view", defaultValue = "questions") String view,
                                    @RequestParam(value = "sort_by", defaultValue = "relevance") String sortBy) {

        ModelAndView modelAndView = new ModelAndView("/users/profile");

        // Get the current user's ID from the session
        Long currentUserId = (Long) session.getAttribute("userId");

        // Check if the user ID is valid and fetch the user details
        Optional<User> activeUser = userRepository.findById(currentUserId);
        if (activeUser.isEmpty()) {
            throw new IllegalArgumentException("User not found with id: " + currentUserId);
        }

        // Fetch the active user's profile with saved schools
        User profileUser = activeUser.get();

        // Fetch the username
        String username = profileUser.getUsername();

        // Fetch saved schools
        List<School> savedSchools = schoolLikeRepository.findSchoolsByUserId(currentUserId);

        // Fetch reviews written by the profile user
        List<ReviewWithData> userReviews = reviewRepository.findByUserId(currentUserId);

        // Add all the necessary data to the model
        modelAndView.addObject("activeUser", activeUser.orElse(null));
        modelAndView.addObject("profileUser", profileUser);
        modelAndView.addObject("username", username);
        modelAndView.addObject("savedSchools", savedSchools);
        modelAndView.addObject("userReviews", userReviews);

        // code for feed:
        modelAndView.addObject("view", view);
        modelAndView.addObject("sortBy", sortBy);

        if (view.equals("questions")) {
            List<QuestionWithData> questions = new ArrayList<QuestionWithData>();

            for (School school: savedSchools) {
                questions.addAll(questionRepository.findQuestionsBySchoolId(school.getId(), currentUserId));
            }
            fetchAnswers(questions, currentUserId);
            if (sortBy.equals("relevance")) {
                questions.sort(Comparator.comparingLong(QuestionWithData::getLikes).reversed());
            } else if (sortBy.equals("recent")) {
                questions.sort(Comparator.comparing(QuestionWithData::getQuestion, Comparator.comparing(Question::getCreatedAt)).reversed());
            }
            modelAndView.addObject("questions", questions);
            modelAndView.addObject("newAnswer", new Answer());
        } else if (view.equals("reviews")) {
            List<ReviewWithData> reviews = new ArrayList<ReviewWithData>();

            for (School school: savedSchools) {
                reviews.addAll(reviewRepository.findReviewsByRecent(school.getId(), currentUserId));
            }
            if (sortBy.equals("relevance")) {
                reviews.sort(Comparator.comparingLong(ReviewWithData::getUpvotes).reversed());
            } else if (sortBy.equals("recent")) {
                reviews.sort(Comparator.comparing(ReviewWithData::getReview, Comparator.comparing(Review::getCreatedAt)).reversed());
            }
            modelAndView.addObject("reviews", reviews);
        }
        return modelAndView;
    }
}
