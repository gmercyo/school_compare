package com.makersacademy.schoolCompare.dto;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionWithData {
    private Long id;
    private String userId;
    private String username;
    private Long schoolId;
    private Long postId;
    private String content;
    private List<QuestionWithData> answers;
    private LocalDateTime createdAt;

    public QuestionWithData(Long id, String userId, String username, Long schoolId,Long postId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.schoolId = schoolId;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public QuestionWithData() {};

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
