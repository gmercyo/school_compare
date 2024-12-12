package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
