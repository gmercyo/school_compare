package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
}
