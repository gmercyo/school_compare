package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Answer;
import com.makersacademy.schoolcompare.pojo.TimeAgo;

import java.time.LocalDateTime;

public class AnswerWithData {
    private Answer answer;
    private String username;
    private Long upvotes;
    private boolean upvotedByCurrentUser;

    public AnswerWithData(Answer answer, String username, Long upvotes, boolean upvotedByCurrentUser) {
        this.answer = answer;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
    }

    public AnswerWithData() {}

    public Answer getAnswer() { return answer; }
    public String getUsername() { return username; }
    public Long getUpvotes() { return upvotes; }
    public boolean isUpvotedByCurrentUser() { return upvotedByCurrentUser; }

    // Extra getters:
    public Long getId() { return answer.getId(); }
    public Long getSchoolId() { return answer.getSchoolId(); }
    public Long getUserId() { return answer.getUserId(); }
    public Long getQuestionId() { return answer.getQuestionId(); }
    public String getRole() { return answer.getRole(); }
    public String getContent() { return answer.getContent(); }
    public LocalDateTime getCreatedAt() { return answer.getCreatedAt(); }
    public String getTimeAgo() { return TimeAgo.calculate(answer.getCreatedAt()); }

    public void setAnswer(Answer answer) { this.answer = answer; }
    public void setUsername(String username) { this.username = username; }
    public void setUpvotes(Long upvotes) { this.upvotes = upvotes; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }
}