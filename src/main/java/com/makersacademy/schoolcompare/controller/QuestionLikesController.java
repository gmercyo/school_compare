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

    @PostMapping("schools/{schoolId}/likes/{questionId}")
    public RedirectView create(@PathVariable Long schoolId, @PathVariable Long questionId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Optional<QuestionLike> existingLike = repository.findByUserIdAndQuestionId(userId, questionId);
        if (existingLike.isPresent()) {
            repository.delete(existingLike.get());
        } else {
            QuestionLike newLike = new QuestionLike(userId, questionId);
            repository.save(newLike);
        }
        return new RedirectView("/schools/" + schoolId);
    }
}
