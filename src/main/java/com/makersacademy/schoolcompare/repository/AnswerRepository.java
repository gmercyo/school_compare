package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.AnswerWithData;
import com.makersacademy.schoolcompare.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    @Query("SELECT new com.makersacademy.schoolcompare.dto.AnswerWithData(a.id, a.userId, u.username, a.role, a.content, a.createdAt, " +
            "(SELECT COUNT(upv.id) FROM AnswerUpvote upv WHERE upv.answerId = a.id)) " +
            "FROM Answer a " +
            "JOIN User u ON a.userId = u.id " +
            "WHERE a.questionId = :questionId " +
            "ORDER BY a.createdAt DESC")
    List<AnswerWithData> getAllByQuestionId(@Param("questionId") Long questionId);
}
