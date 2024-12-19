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
    @Query("SELECT q, u.username FROM Question q JOIN User u ON q.userId = u.id WHERE q.schoolId = :schoolId " )
    public List<Question> getAllBySchool(@Param("schoolId") Long schoolId);

    @Query("SELECT new com.makersacademy.schoolcompare.dto.QuestionWithData(" +
            "q, u.username, (SELECT COUNT(qqll) FROM QuestionLike qqll WHERE qqll.questionId = q.id), " +
            "ql.userId IS NOT NULL, " +
            "s) " +
            "FROM School s " +
            "JOIN Question q ON q.schoolId = s.id " +
            "JOIN User u ON u.id = q.userId " +
            "LEFT JOIN QuestionLike ql ON ql.questionId = q.id AND ql.userId = :currentUser " +
            "WHERE s.id = :schoolId")
    List<QuestionWithData> findQuestionsBySchoolId(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);
}
