package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.ReviewWithData;
import com.makersacademy.schoolcompare.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.review = r), " +
            "CASE WHEN ru.user IS NOT NULL THEN true ELSE false END) " +
            "FROM School s " +
            "JOIN Review r ON r.school = s " +
            "JOIN User u ON u.id = r.user.id " +
            "LEFT JOIN ReviewUpvote ru ON ru.review = r AND ru.user.id = :currentUser " +
            "WHERE s.id = :schoolId " +
            "ORDER BY (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.review = r) DESC")
    List<ReviewWithData> findReviewsByRelevance(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);


    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, (SELECT COUNT(rruu) FROM ReviewUpvote rruu WHERE rruu.review.id = r.id), " +
            "CASE WHEN ru.user.id IS NOT NULL THEN true ELSE false END) " +
            "FROM School s " +
            "JOIN Review r ON r.school.id = s.id " +
            "JOIN User u ON u.id = r.user.id " +  // Correct the references to user.id instead of userId
            "LEFT JOIN ReviewUpvote ru ON ru.review.id = r.id AND ru.user.id = :currentUser " +
            "WHERE s.id = :schoolId " +
            "ORDER BY r.createdAt DESC")
    List<ReviewWithData> findReviewsByRecent(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);


    @Query("SELECT new com.makersacademy.schoolcompare.dto.ReviewWithData(" +
            "r, u.username, " +
            "(SELECT COUNT(rru) FROM ReviewUpvote rru WHERE rru.review.id = r.id), " +
            "CASE WHEN ru.user.id IS NOT NULL THEN true ELSE false END) " +
            "FROM Review r " +
            "JOIN r.user u " +
            "LEFT JOIN ReviewUpvote ru ON ru.review.id = r.id AND ru.user.id = :currentUser " +
            "WHERE r.school.id = :schoolId " +
            "ORDER BY (SELECT COUNT(rru) FROM ReviewUpvote rru WHERE rru.review.id = r.id) DESC")
    ReviewWithData findTopReview(@Param("schoolId") Long schoolId, @Param("currentUser") Long currentUser);



    List<Review> findByUser_Id(Long userId);


}
