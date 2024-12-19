package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.AnswerUpvote;
import com.makersacademy.schoolcompare.repository.AnswerUpvoteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class AnswerUpvotesController {
    @Autowired
    AnswerUpvoteRepository repository;

    @PostMapping("questions/{questionID}/answer-upvotes/{answerId}")
    public RedirectView create(@PathVariable Long questionId, @PathVariable Long answerId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Optional<AnswerUpvote> existingUpvote = repository.findByUserIdAndAnswerId(userId, answerId);
        if (existingUpvote.isPresent()) {
            repository.delete(existingUpvote.get());
        } else {
            AnswerUpvote newUpvote = new AnswerUpvote(userId, answerId);
            repository.save(newUpvote);
        }
        return new RedirectView("/schools/" + questionId + "?view=answers&sort_by=relevance");
    }
}
