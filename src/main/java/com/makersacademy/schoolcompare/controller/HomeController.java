package com.makersacademy.schoolcompare.controller;

import com.makersacademy.schoolcompare.model.User;
import com.makersacademy.schoolcompare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;

	@Value("${MAPBOX_API_TOKEN:}")
	private String mapboxToken;

	@GetMapping(value = "/")
	public String index(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = userRepository.findById(userId).orElse(null);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("mapboxToken", mapboxToken);
		return "schools/index";
	}
}
