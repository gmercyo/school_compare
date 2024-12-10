package com.makersacademy.schoolCompare.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	@Value("${MAPBOX_API_TOKEN:}")
	private String mapboxToken;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("mapboxToken", mapboxToken);
		return "schools/index";
	}
}
