package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.Question;
import com.makersacademy.schoolCompare.model.School;
import com.makersacademy.schoolCompare.repository.QuestionRepository;
import com.makersacademy.schoolCompare.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.makersacademy.schoolCompare.pojo.FilterCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class SchoolsController {

    @Autowired
    SchoolRepository repository;
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("schools/{id}")
    public ModelAndView showSchoolInfo(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("/schools/show-school");
        Optional<School> school = repository.findById(id); // Use findById for a single entity
        if (school.isPresent()) {
            List<Question> questions = questionRepository.getAllBySchool(id);
            System.out.println(questions.size() + " this many questions>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            modelAndView.addObject("school", school.get());
            modelAndView.addObject("questions", questions);

        } else {
            // Handle case when school is not found, e.g., show a "not found" page or return an error message
            modelAndView.addObject("error", "School not found");
        }
        return modelAndView;
    }

    @PostMapping(value = "/schools/api")
    @ResponseBody
    public ResponseEntity<List<School>> getSchools(@RequestBody FilterCriteria filterCriteria) {
        List<School> filteredSchools = repository.findSchoolsByFilterCriteria(
                filterCriteria.getAges(),
                filterCriteria.getGender(),
                filterCriteria.getRating(),
                filterCriteria.getAffiliation());
        return ResponseEntity.ok(filteredSchools);
    }

}
