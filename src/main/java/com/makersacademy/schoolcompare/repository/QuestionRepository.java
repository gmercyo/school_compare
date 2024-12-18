package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.QuestionWithData;
import com.makersacademy.schoolcompare.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Query("SELECT new com.makersacademy.schoolcompare.dto.QuestionWithData(" +
            "q.id, q, u.username, q.content, " +
            "(SELECT COUNT(l) FROM QuestionLike l WHERE l.questionId = q.id), " +
            "(SELECT COUNT(a.id) FROM Answer a WHERE a.questionId = q.id), " +
            "(SELECT MAX(a.createdAt) FROM Answer a WHERE a.questionId = q.id), " + // Fetch latest answer timestamp
            "CASE WHEN EXISTS (SELECT 1 FROM QuestionLike l WHERE l.questionId = q.id AND l.userId = :currentUser) " +
            "THEN true ELSE false END) " +
            "FROM Question q " +
            "JOIN User u ON q.userId = u.id " +
            "WHERE q.schoolId = :schoolId")
    List<QuestionWithData> findQuestionsBySchoolId(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);
}
