package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.dto.UserGeodata;
import com.makersacademy.schoolcompare.model.QuestionLike;
import com.makersacademy.schoolcompare.model.Review;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.ReviewRepository;
import com.makersacademy.schoolcompare.repository.SchoolRepository;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class UsersController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    SchoolRepository schoolRepository;


    @GetMapping("/users/after-login")
    public RedirectView afterLogin(HttpSession session,
                                   @AuthenticationPrincipal DefaultOidcUser principal) {

        String username = (String) principal.getAttributes().get("nickname");
        String auth0Id = (String) principal.getAttributes().get("sub");
        User user = userRepository
                .findUserByAuth0Id(auth0Id)
                .map(existingUser -> {
                    existingUser.setUsername(username);
                    return userRepository.save(existingUser);
                })
                .orElseGet(() -> userRepository.save(new User(username, auth0Id, "", null, null)));

        session.setAttribute("userId", user.getId());
        return new RedirectView("/");
    }

    @PatchMapping("/users/geodata")
    public ResponseEntity<Void> update(HttpSession session, @RequestBody UserGeodata geodata) {
        System.out.println(geodata);
        Long userId = (Long) session.getAttribute("userId");
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            String address = geodata.getAddress();
            if (address != null) user.setAddress(address);
            user.setLatitude(geodata.getLatitude());
            user.setLongitude(geodata.getLongitude());
            userRepository.save(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/profile/{id}")
    public ModelAndView userProfile(
            @PathVariable Long id,
            HttpSession session,
            @AuthenticationPrincipal DefaultOidcUser principal) {

        ModelAndView modelAndView = new ModelAndView("/users/profile");

        // Fetch the currently logged-in user ID from the session
        Long currentUserId = (Long) session.getAttribute("userId");
        Optional<User> activeUser = userRepository.findById(currentUserId);

        // Fetch the user profile details based on the provided ID
        Optional<User> profileUserOptional = userRepository.findById(id);
        if (profileUserOptional.isEmpty()) {
            // If the profile user doesn't exist, redirect or return an error page
            modelAndView.setViewName("error/404");
            return modelAndView;
        }
        User profileUser = profileUserOptional.get();

        // Fetch the username
        String username = profileUser.getUsername();

        // Fetch saved schools
        List<School> savedSchools = schoolRepository.findBySavedByUsers_Id(profileUser.getId());

        // Fetch reviews written by the profile user
        List<Review> userReviews = reviewRepository.findByUserId(profileUser.getId());


        // Add all the necessary data to the model
        modelAndView.addObject("username", username);
        modelAndView.addObject("savedSchools", savedSchools);
        modelAndView.addObject("userReviews", userReviews);

        return modelAndView;
    }
}
