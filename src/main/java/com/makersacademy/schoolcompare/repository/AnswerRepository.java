package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.AnswerWithData;
import com.makersacademy.schoolcompare.dto.QuestionWithData;
import com.makersacademy.schoolcompare.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    @Query("SELECT new com.makersacademy.schoolcompare.dto.AnswerWithData(" +
            "a, u.username, (SELECT COUNT(aauu) FROM AnswerUpvote aauu WHERE aauu.answerId = a.id), " +
            "au.userId IS NOT NULL) " +
            "FROM Question q " +
            "JOIN Answer a ON a.questionId = q.id " +
            "JOIN User u ON u.id = a.userId " +
            "LEFT JOIN AnswerUpvote au ON au.answerId = a.id AND au.userId = :currentUser " +
            "WHERE q.id = :questionId")
    List<AnswerWithData> findAnswersByRelevance(@Param("questionId") Long questionId, @Param("currentUser") Long currentUser);
    @Query("SELECT new com.makersacademy.schoolcompare.dto.AnswerWithData(" +
            "a.id, a.userId, u.username, a.role, a.content, a.createdAt, " +
            "(SELECT COUNT(upv.id) FROM AnswerUpvote upv WHERE upv.answerId = a.id)) " +
            "FROM Answer a " +
            "JOIN User u ON a.userId = u.id " +
            "LEFT JOIN AnswerUpvote v ON a.id = v.answerId " +
            "WHERE a.questionId = :questionId")
    List<AnswerWithData> getAllByQuestionId(@Param("questionId") Long questionId);


}
