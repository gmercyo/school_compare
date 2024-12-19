package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.Review;
import com.makersacademy.schoolcompare.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
public class ReviewsController {
    @Autowired
    ReviewRepository repository;

    @PostMapping("/reviews")
    public RedirectView create(@ModelAttribute Review review) {
        review.setCreatedAt(LocalDateTime.now());
        repository.save(review);
        return new RedirectView("/schools/" + review.getSchoolId() + "?view=reviews&sort_by=recent");
    }
}
