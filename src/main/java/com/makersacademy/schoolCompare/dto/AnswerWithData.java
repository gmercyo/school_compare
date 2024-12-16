package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Answer;

public class AnswerWithData {
    private Answer answer;
    private String username;
    private int upvotes;
    private boolean upvotedByCurrentUser;

    public AnswerWithData(Answer answer, String username, int upvotes, boolean upvotedByCurrentUser) {
        this.answer = answer;
        this.username = username;
        this.upvotes = upvotes;
        this.upvotedByCurrentUser = upvotedByCurrentUser;
    }

    public AnswerWithData() {}

    public void setAnswer(Answer answer) { this.answer = answer; }
    public void setUsername(String username) { this.username = username; }
    public void setUpvotes(int upvotes) { this.upvotes = upvotes; }
    public void setUpvotedByCurrentUser(boolean upvotedByCurrentUser) { this.upvotedByCurrentUser = upvotedByCurrentUser; }
}