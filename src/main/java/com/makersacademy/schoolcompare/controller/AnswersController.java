package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.repository.AnswerRepository;
import com.makersacademy.schoolcompare.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
public class AnswersController {
    @Autowired
    AnswerRepository repository;

    @PostMapping("/answers")
    public RedirectView create(@ModelAttribute Answer answer) {
        answer.setCreatedAt(LocalDateTime.now());
        repository.save(answer);
        return new RedirectView("/schools/" + answer.getQuestionId() + "view=answers&sort_by=recent");
    }

}
