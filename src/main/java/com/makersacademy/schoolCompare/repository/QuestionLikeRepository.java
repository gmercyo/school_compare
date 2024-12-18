package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.model.QuestionLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {
    public Optional<QuestionLike> findByUserIdAndQuestionId(@Param("userId") Long userId, @Param("questionId") Long questionId);
}
