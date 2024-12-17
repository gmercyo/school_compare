package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.dto.AnswerWithData;
import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.repository.AnswerRepository;
import com.makersacademy.schoolcompare.repository.QuestionRepository;
import com.makersacademy.schoolcompare.repository.SchoolRepository;
import com.makersacademy.schoolcompare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;

public class AnswersController {
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/new-answer")
    public RedirectView create(@ModelAttribute Answer answer) {
        answer.setCreatedAt(LocalDateTime.now());
        answerRepository.save(answer);
        return new RedirectView("/schools/" + answer.getSchoolId() + "/questions/" + answer.getQuestionId());
    }
    @GetMapping("schools/{schoolId}/questions/{questionId}/answers")
    public ModelAndView showAnswers(@PathVariable("questionId") Long questionId) {
        ModelAndView modelAndView = new ModelAndView("/questions/show-answers");
        List<AnswerWithData> answers = answerRepository.getAllByQuestionId(questionId);
        modelAndView.addObject("answers", answers);
        return modelAndView;
    }

}
