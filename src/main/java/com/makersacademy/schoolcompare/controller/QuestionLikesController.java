package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.QuestionLike;
import com.makersacademy.schoolcompare.repository.QuestionLikeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class QuestionLikesController {
    @Autowired
    QuestionLikeRepository repository;

    @PostMapping("/likes/{questionId}")
    public RedirectView toggleLike(@PathVariable Long questionId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        // Check if the user already liked this question
        Optional<QuestionLike> existingLike = repository.findByUserIdAndQuestionId(userId, questionId);

        if (existingLike.isPresent()) {
            // If user already liked, remove the like (unlike)
            repository.delete(existingLike.get());
        } else {
            // If user hasn't liked yet, add the like
            repository.save(new QuestionLike(userId, questionId));
        }

        return new RedirectView("/schools/" + questionId);
    }
}