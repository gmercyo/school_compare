package com.makersacademy.schoolcompare.dto;

import java.time.LocalDateTime;

public class AnswerWithData {
    private Long id;
    private Long questionId;
    private Long userId;
    private String username;
    private String role;
    private String content;
    private LocalDateTime createdAt;
    private Long upvotesCount;

    public AnswerWithData(Long id, Long userId, String username, String role, String content,
                          LocalDateTime createdAt, Long upvotesCount) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.content = content;
        this.createdAt = createdAt;
        this.upvotesCount = upvotesCount;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getUpvotesCount() { return upvotesCount; }
    public void setUpvotesCount(Long upvotesCount) { this.upvotesCount = upvotesCount; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
}
