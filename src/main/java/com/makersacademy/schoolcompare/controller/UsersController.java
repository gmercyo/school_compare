package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.dto.ReviewWithData;
import com.makersacademy.schoolcompare.dto.UserGeodata;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.ReviewRepository;
import com.makersacademy.schoolcompare.repository.SchoolLikeRepository;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    SchoolLikeRepository schoolLikeRepository;


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
}

