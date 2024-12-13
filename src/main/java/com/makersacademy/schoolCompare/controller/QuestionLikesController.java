package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.QuestionLike;
import com.makersacademy.schoolCompare.repository.QuestionLikeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class QuestionLikesController {
    @Autowired
    QuestionLikeRepository repository;

    @PostMapping("/likes/{questionId}")
    public RedirectView create(@PathVariable Long questionId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        repository.save(new QuestionLike(userId, questionId));
        return new RedirectView("/schools/" + questionId );
    }
}
