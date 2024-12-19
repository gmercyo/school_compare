package com.makersacademy.schoolcompare.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long schoolId;
    private Long userId;
    private String role;
    private String content;
    private LocalDateTime createdAt;

    public Review(Long schoolId, Long userId, String role, String content, LocalDateTime createdAt) {
        this.schoolId = schoolId;
        this.userId = userId;
        this.role = role;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Review() {}

    public Long getId() { return id; }
    public Long getSchoolId() { return schoolId; }
    public Long getUserId() { return userId; }
    public String getRole() { return role; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setSchoolId(Long schoolId) { this.schoolId = schoolId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setRole(String role) { this.role = role; }
    public void setContent(String content) { this.content = content; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}