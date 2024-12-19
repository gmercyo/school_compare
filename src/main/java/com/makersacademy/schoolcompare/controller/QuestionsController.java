package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.QuestionRepository;
import com.makersacademy.schoolcompare.repository.SchoolRepository;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class QuestionsController {
    @Autowired
    QuestionRepository repository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("schools/{schoolId}/questions/new")
    public String newQuestion(@PathVariable("schoolId") long schoolId, HttpSession session, Model model) {
        School school = schoolRepository.findById(schoolId).orElseThrow();
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("school", school);
        model.addAttribute("question", new Question());
        return "/questions/new";
    }

    @PostMapping("/questions")
    public RedirectView create(@ModelAttribute Question question, HttpSession session) {
        question.setCreatedAt(LocalDateTime.now());
        repository.save(question);
        return new RedirectView("/schools/" + question.getSchoolId() );
    }

    @GetMapping("schools/{school}/questions/{questionId}")
    public ModelAndView showQuestion(@PathVariable("school") Long schoolId, @PathVariable("questionId") Long questionId) {
        ModelAndView modelAndView = new ModelAndView("/questions/show-question");
        Optional<Question> question = repository.findById(questionId);
        if (question.isPresent()) {
            Question q = question.get();
            modelAndView.addObject("question", q);
            User u = userRepository.findById(q.getUserId()).get();
            modelAndView.addObject("username", u.getUsername());
        }
        return modelAndView;
    }


}
