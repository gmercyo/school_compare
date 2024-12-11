package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.School;
import com.makersacademy.schoolCompare.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("schools/{id}")
    public ModelAndView showSchoolInfo(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("/schools/show-school");
        Optional<School> school = schoolRepository.findById(id); // Use findById for a single entity
        if (school.isPresent()) {
            modelAndView.addObject("school", school.get());
        } else {
            // Handle case when school is not found, e.g., show a "not found" page or return an error message
            modelAndView.addObject("error", "School not found");
        }
        return modelAndView;
    }


}
