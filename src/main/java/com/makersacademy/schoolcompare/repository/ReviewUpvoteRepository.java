package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.ReviewUpvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewUpvoteRepository extends CrudRepository<ReviewUpvote, Long> {
    public Optional<ReviewUpvote> findByUserIdAndReviewId(@Param("userId") Long userId, @Param("reviewId") Long reviewId);
}
