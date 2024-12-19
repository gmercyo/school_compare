package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.ReviewWithData;
import com.makersacademy.schoolcompare.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id), " +
            "CASE WHEN ru.userId IS NOT NULL THEN true ELSE false END, " +
            "s) " +
            "FROM School s " +
            "JOIN Review r ON r.schoolId = s.id " +
            "JOIN User u ON u.id = r.userId " +
            "LEFT JOIN ReviewUpvote ru ON ru.reviewId = r.id AND ru.userId = :currentUser " +
            "WHERE s.id = :schoolId " +
            "ORDER BY (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id) DESC")
    List<ReviewWithData> findReviewsByRelevance(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);

    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id), " +
            "CASE WHEN ru.userId IS NOT NULL THEN true ELSE false END, " +
            "s) " +
            "FROM School s " +
            "JOIN Review r ON r.schoolId = s.id " +
            "JOIN User u ON u.id = r.userId " +
            "LEFT JOIN ReviewUpvote ru ON ru.reviewId = r.id AND ru.userId = :currentUser " +
            "WHERE s.id = :schoolId " +
            "ORDER BY r.createdAt DESC")
    List<ReviewWithData> findReviewsByRecent(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);

    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id), " +
            "CASE WHEN ru.userId IS NOT NULL THEN true ELSE false END) " +
            "FROM School s " +
            "JOIN Review r ON r.schoolId = s.id " +
            "JOIN User u ON u.id = r.userId " +
            "LEFT JOIN ReviewUpvote ru ON ru.reviewId = r.id AND ru.userId = :currentUser " +
            "WHERE s.id = :schoolId " +
            "ORDER BY (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id) DESC " +
            "LIMIT 1")
    ReviewWithData findTopReview(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);

    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id), " +
            "CASE WHEN ru.userId IS NOT NULL THEN true ELSE false END, " +
            "s) " +
            "FROM School s " +
            "JOIN Review r ON r.schoolId = s.id " +
            "JOIN User u ON u.id = r.userId " +
            "LEFT JOIN ReviewUpvote ru ON ru.reviewId = r.id AND ru.userId = :currentUser " +
            "WHERE u.id = :currentUser " +
            "ORDER BY (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.reviewId = r.id) DESC")
    List<ReviewWithData> findByUserId(@Param("currentUser") Long currentUser);
}
