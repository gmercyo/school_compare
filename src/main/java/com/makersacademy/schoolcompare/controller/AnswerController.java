package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.repository.AnswerRepository;
import com.makersacademy.schoolcompare.repository.QuestionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

public class AnswerController {
    @Autowired
    AnswerRepository repository;
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/answers")
    public RedirectView create(@ModelAttribute Answer answer, HttpSession session) {
        answer.setCreatedAt(LocalDateTime.now());
        repository.save(answer);
        return new RedirectView("/schools/" + answer.getSchoolId());
    }

}
