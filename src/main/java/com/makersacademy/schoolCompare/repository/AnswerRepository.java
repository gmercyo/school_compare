package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
