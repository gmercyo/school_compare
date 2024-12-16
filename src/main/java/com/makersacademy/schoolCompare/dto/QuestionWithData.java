package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Question;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionWithData {
    private Question question;
    private String username;
    private int likes;
    private boolean likedByCurrentUser;
    private LocalDateTime lastAnswerTimestamp;
    private List<AnswerWithData> answers;

    public QuestionWithData(Question question,
                            String username,
                            int likes,
                            boolean likedByCurrentUser,
                            LocalDateTime lastAnswerTimestamp,
                            List<AnswerWithData> answers) {
        this.question = question;
        this.username = username;
        this.likes = likes;
        this.likedByCurrentUser = likedByCurrentUser;
        this.lastAnswerTimestamp = lastAnswerTimestamp;
        this.answers = answers;
    }

    public QuestionWithData() {};

    public Question getQuestion() { return question; }
    public String getUsername() { return username; }
    public int getLikes() { return likes; }
    public boolean isLikedByCurrentUser() { return likedByCurrentUser; }
    public LocalDateTime getLastAnswerTimestamp() { return lastAnswerTimestamp; }
    public List<AnswerWithData> getAnswers() { return answers; }

    public void setQuestion(Question question) { this.question = question; }
    public void setUsername(String username) { this.username = username; }
    public void setLikes(int likes) { this.likes = likes; }
    public void setLikedByCurrentUser(boolean likedByCurrentUser) { this.likedByCurrentUser = likedByCurrentUser; }
    public void setLastAnswerTimestamp(LocalDateTime lastAnswerTimestamp) { this.lastAnswerTimestamp = lastAnswerTimestamp; }
    public void setAnswers(List<AnswerWithData> answers) { this.answers = answers; }
}