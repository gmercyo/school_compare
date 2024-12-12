package com.makersacademy.schoolCompare.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long schoolId;
    private Long userId;
    private Long questionId;
    private String role;
    private String content;
    private LocalDateTime createdAt;

    public Answer() {}

    public Answer(Long schoolId, Long userId, Long questionId, String role, String content, LocalDateTime createdAt) {
        this.schoolId = schoolId;
        this.userId = userId;
        this.questionId = questionId;
        this.role = role;
        this.content = content;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public Long getSchool_id() {
        return schoolId;
    }

    public Long getUser_id() {
        return userId;
    }

    public Long getQuestion_id() {
        return questionId;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchool_id(Long schoolId) {
        this.schoolId = schoolId;
    }

    public void setUser_id(Long userId) {
        this.userId = userId;
    }

    public void setQuestion_id(Long questionId) {
        this.questionId = questionId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated_at(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

