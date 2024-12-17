package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.pojo.TimeAgo;

import java.time.LocalDateTime;

public class AnswerWithData {
    private Long id;
    private Long questionId;
    private Long userId;
    private String username;
    private String role;
//    private Answer answer;
    private String content;
    private LocalDateTime createdAt;
    private Long upvotes;
    private boolean upvotedByCurrentUser;

    public AnswerWithData() {}
//    public AnswerWithData(Answer answer, String username, Long upvotes, ) {
//        this.answer = answer;
    public AnswerWithData(Long id, Long userId, String username, String role, String content,
                          LocalDateTime createdAt, Long upvotes, boolean upvotedByCurrentUser) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
        this.role = role;
        this.content = content;
        this.createdAt = createdAt;
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

    public Long getUpvotes() { return upvotes; }
    public void setUpvotes(Long upvotes) { this.upvotes = upvotes; }

    public boolean isUpvotedByCurrentUser() { return upvotedByCurrentUser; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
    public String getTimeAgo() { return TimeAgo.calculate(answer.getCreatedAt()); }

}