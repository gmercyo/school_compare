package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.AnswerUpvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerUpvoteRepository  extends CrudRepository<AnswerUpvote, Long> {
    public Optional<AnswerUpvote> findByUserIdAndAnswerId(@Param("userId") Long userId, @Param("answerId") Long answerId);
}
