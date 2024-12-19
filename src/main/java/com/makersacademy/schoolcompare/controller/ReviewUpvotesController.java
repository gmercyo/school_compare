package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.ReviewUpvote;
import com.makersacademy.schoolcompare.repository.ReviewUpvoteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class ReviewUpvotesController {
    @Autowired
    ReviewUpvoteRepository repository;

    @PostMapping("schools/{schoolId}/review-upvotes/{reviewId}")
    public RedirectView create(@PathVariable Long schoolId, @PathVariable Long reviewId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Optional<ReviewUpvote> existingUpvote = repository.findByUserIdAndReviewId(userId, reviewId);
        if (existingUpvote.isPresent()) {
            repository.delete(existingUpvote.get());
        } else {
            ReviewUpvote newUpvote = new ReviewUpvote(userId, reviewId);
            repository.save(newUpvote);
        }
        return new RedirectView("/schools/" + schoolId + "?view=reviews&sort_by=relevance");
    }
}
