package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.ReviewUpvoteId;
import jakarta.persistence.*;

@Entity
@Table(name="REVIEW_UPVOTES")
@IdClass(ReviewUpvoteId.class)
public class ReviewUpvote {
    @Id
    @JoinColumn(name = "user_id")
    private Long userId;
    @Id
    @JoinColumn(name = "review_id")
    private Long reviewId;

    public ReviewUpvote(Long userId, Long reviewId) {
        this.userId = userId;
        this.reviewId = reviewId;
    }

    public ReviewUpvote() {}

    public Long getUserId() { return userId; }
    public Long getReviewId() { return reviewId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
}
