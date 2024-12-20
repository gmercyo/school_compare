package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Review;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.pojo.TimeAgo;

import java.time.LocalDateTime;

public class ReviewWithData {
    private Review review;
    private String username;
    private Long upvotes;
    private boolean upvotedByCurrentUser;
    private School school;

    public ReviewWithData(Review review, String username, Long upvotes, boolean upvotedByCurrentUser) {
        this.review = review;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
    }

    public ReviewWithData(Review review, String username, Long upvotes, boolean upvotedByCurrentUser, School school) {
        this.review = review;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
        this.school = school;
    }

    public ReviewWithData() {}

    public Review getReview() { return review; }
    public String getUsername() { return username; }
    public Long getUpvotes() { return upvotes; }
    public boolean isUpvotedByCurrentUser() { return upvotedByCurrentUser; }
    public School getSchool() { return school; }

    // Extra getters:
    public Long getId() { return review.getId(); }
    public Long getSchoolId() { return review.getSchoolId(); }
    public Long getUserId() { return review.getUserId(); }
    public String getRole() { return review.getRole(); }
    public String getContent() { return review.getContent(); }
    public LocalDateTime getCreatedAt() { return review.getCreatedAt(); }
    public String getTimeAgo() { return TimeAgo.calculate(review.getCreatedAt()); }

    public void setReview(Review review) { this.review = review; }
    public void setUsername(String username) { this.username = username; }
    public void setUpvotes(Long upvotes) { this.upvotes = upvotes; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }
    public void setSchool(School school) { this.school = school; }
}