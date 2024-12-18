package com.makersacademy.schoolcompare.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many-to-one relationship with School (assuming Review is linked to School via schoolId)
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    private String role;
    private String content;
    private LocalDateTime createdAt;

    public Review() {}

    public Review(School school, User user, String role, String content, LocalDateTime createdAt) {
        this.school = school;
        this.user = user;
        this.role = role;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public School getSchool() { return school; }
    public String getRole() { return role; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public Long getSchoolId() {
        return school != null ? school.getId() : null;
    }

    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setSchool(School school) { this.school = school; }
    public void setRole(String role) { this.role = role; }
    public void setContent(String content) { this.content = content; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
