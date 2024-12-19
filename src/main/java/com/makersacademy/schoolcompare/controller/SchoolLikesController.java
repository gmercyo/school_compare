package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.SchoolLike;
import com.makersacademy.schoolcompare.repository.SchoolLikeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class SchoolLikesController {
    @Autowired
    SchoolLikeRepository repository;

    @PostMapping("school-likes/{schoolId}")
    public RedirectView create(@PathVariable Long schoolId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Optional<SchoolLike> existingLike = repository.findByUserIdAndSchoolId(userId, schoolId);
        if (existingLike.isPresent()) {
            repository.delete(existingLike.get());
        } else {
            SchoolLike newLike = new SchoolLike(userId, schoolId);
            repository.save(newLike);
        }
        return new RedirectView("/schools/" + schoolId);
    }
}