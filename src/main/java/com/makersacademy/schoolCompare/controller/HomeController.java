package com.makersacademy.schoolCompare.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	@ResponseBody
	public String index() {
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();


		return "You are logged in as " + currentUser;
	}
}
