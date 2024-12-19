package com.makersacademy.schoolcompare.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReviewUpvoteId {
    @Column(name = "user_id", insertable=false, updatable=false)
    private Long userId;
    @Column(name = "review_id", insertable=false, updatable=false)
    private Long reviewId;

    public ReviewUpvoteId(Long userId, Long reviewId) {
        this.userId = userId;
        this.reviewId = reviewId;
    }

    public ReviewUpvoteId() {}

    public Long getUserId() { return userId; }
    public Long getReviewId() { return reviewId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
}
