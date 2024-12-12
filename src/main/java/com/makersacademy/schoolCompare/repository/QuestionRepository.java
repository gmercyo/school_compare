package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
