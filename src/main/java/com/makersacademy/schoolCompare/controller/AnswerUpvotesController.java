package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.AnswerUpvote;
import com.makersacademy.schoolCompare.repository.AnswerUpvoteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AnswerUpvotesController {
    @Autowired
    AnswerUpvoteRepository repository;

    @PostMapping("/upvotes/{answerId}")
    public RedirectView create(@PathVariable Long answerId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        repository.save(new AnswerUpvote(userId, answerId));
        return new RedirectView("/schools/" + answerId );
    }
}
