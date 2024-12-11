package com.makersacademy.schoolCompare.controller;

import com.makersacademy.schoolCompare.model.School;
import com.makersacademy.schoolCompare.pojo.FilterCriteria;
import com.makersacademy.schoolCompare.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class SchoolsController {
    @Autowired
    SchoolRepository repository;

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
