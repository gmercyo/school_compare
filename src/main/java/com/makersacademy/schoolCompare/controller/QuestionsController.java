package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.Question;
import com.makersacademy.schoolCompare.model.School;
import com.makersacademy.schoolCompare.repository.QuestionRepository;
import com.makersacademy.schoolCompare.repository.SchoolRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionsController {
    @Autowired
    QuestionRepository repository;
    @Autowired
    SchoolRepository schoolRepository;

    private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("schools/{schoolId}/questions/new")
    public String newQuestion(@PathVariable("schoolId") long schoolId, HttpSession session, Model model) {
        School school = schoolRepository.findById(schoolId).orElseThrow();
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("school", school);
        model.addAttribute("question", new Question());
        return "/questions/new";
    }
}
