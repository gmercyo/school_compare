package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.QuestionLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {
    Optional<QuestionLike> findByUserIdAndQuestionId(Long userId, Long questionId);
    List<QuestionLike> findByUserId(Long userId);
}
