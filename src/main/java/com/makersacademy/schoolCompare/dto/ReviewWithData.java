package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Review;

public class ReviewWithData {
    private Review review;
    private String username;
    private Long upvotes;
    private boolean upvotedByCurrentUser;

    public ReviewWithData(Review review, String username, Long upvotes, boolean upvotedByCurrentUser) {
        this.review = review;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
    }

    public ReviewWithData() {}

    public Review getReview() { return review; }
    public String getUsername() { return username; }
    public Long getUpvotes() { return upvotes; }
    public boolean isUpvotedByCurrentUser() { return upvotedByCurrentUser; }

    public void setReview(Review review) { this.review = review; }
    public void setUsername(String username) { this.username = username; }
    public void setUpvotes(Long upvotes) { this.upvotes = upvotes; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }
}