package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    UserRepository userRepository;

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
                .orElseGet(() -> userRepository.save(new User(username, auth0Id)));

        session.setAttribute("userId", user.getId());
        return new RedirectView("/");
    }

    @GetMapping("/profile/{id}")
    public ModelAndView userProfile(@PathVariable Long id,HttpSession session, @AuthenticationPrincipal DefaultOidcUser principal) {
        ModelAndView modelAndView = new ModelAndView("/user/profile");

        Long currentUserId = (Long)session.getAttribute("userId");
        Optional<User> activeUser = userRepository.findById(currentUserId);

        Optional<User> profileUser = userRepository.findById(currentUserId);

        modelAndView.addObject("activeUser", activeUser);
        modelAndView.addObject("profileUser",profileUser);

        return modelAndView;
    }
}
