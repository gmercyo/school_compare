package com.makersacademy.schoolcompare.dto;

import java.time.LocalDateTime;

public class AnswerWithData {
    private Long answerId;
    private Long userId;
    private String username;
    private String role;
    private String answerContent;
    private LocalDateTime answerCreatedAt;
    private Integer upvotesCount;

    public AnswerWithData(Long answerId, Long userId, String username, String role, String answerContent,
                          LocalDateTime answerCreatedAt, Integer upvotesCount) {
        this.answerId = answerId;
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.answerContent = answerContent;
        this.answerCreatedAt = answerCreatedAt;
        this.upvotesCount = upvotesCount;
    }
    public Long getAnswerId() { return answerId; }
    public void setAnswerId(Long answerId) { this.answerId = answerId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getrole() { return role; }
    public void setrole(String role) { this.role = role; }

    public String getAnswerContent() { return answerContent; }
    public void setAnswerContent(String answerContent) { this.answerContent = answerContent; }

    public LocalDateTime getAnswerCreatedAt() { return answerCreatedAt; }
    public void setAnswerCreatedAt(LocalDateTime answerCreatedAt) { this.answerCreatedAt = answerCreatedAt; }

    public Integer getUpvotesCount() { return upvotesCount; }
    public void setUpvotesCount(Integer upvotesCount) { this.upvotesCount = upvotesCount; }
}
