package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.QuestionLike;
import com.makersacademy.schoolcompare.repository.QuestionLikeRepository;
import com.makersacademy.schoolcompare.repository.QuestionRepository;
import com.makersacademy.schoolcompare.repository.SchoolRepository;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.makersacademy.schoolcompare.pojo.FilterCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SchoolsController {

    @Autowired
    SchoolRepository repository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionLikeRepository questionLikeRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("schools/{id}")
    public ModelAndView showSchoolInfo(
            @PathVariable("id") Long id,
            @RequestParam(value = "view", defaultValue = "questions") String view,
            @RequestParam(value = "sort_by", defaultValue = "relevance") String sortBy,
            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("/schools/show-school");
        Optional<School> school = repository.findById(id); // Use findById for a single entity
        if (school.isPresent()) {
            List<Question> questions = questionRepository.getAllBySchool(id);
            modelAndView.addObject("school", school.get());
            modelAndView.addObject("questions", questions);

            // Get user ID from session
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {
                // Get all liked questions for the current user
                List<QuestionLike> likedQuestions = questionLikeRepository.findByUserId(userId);

                // Collect the question IDs that the user has liked
                List<Long> likedQuestionIds = likedQuestions.stream()
                        .map(QuestionLike::getQuestionId) // Ensure QuestionLike is recognized
                        .collect(Collectors.toList());

                // Add the liked question IDs to the model
                modelAndView.addObject("likedQuestionIds", likedQuestionIds);
            }
        } else {
            modelAndView.addObject("error", "School not found");
        }
        return modelAndView;
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
