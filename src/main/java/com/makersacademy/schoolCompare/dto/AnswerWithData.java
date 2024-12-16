package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Answer;

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

    public void setAnswer(Answer answer) { this.answer = answer; }
    public void setUsername(String username) { this.username = username; }
    public void setUpvotes(Long upvotes) { this.upvotes = upvotes; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }
}