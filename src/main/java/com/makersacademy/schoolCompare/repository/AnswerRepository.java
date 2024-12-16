package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
