package com.makersacademy.schoolcompare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "REVIEW_UPVOTES")
public class ReviewUpvote {

    @Id  // Part of the composite primary key
    @ManyToOne
    @JoinColumn(name = "review_id", referencedColumnName = "id", nullable = false)
    private Review review;

    @Id  // Part of the composite primary key
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    // Default constructor
    public ReviewUpvote() {}

    // Constructor with review and user
    public ReviewUpvote(Review review, User user) {
        this.review = review;
        this.user = user;
    }

    // Getters and setters
    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
