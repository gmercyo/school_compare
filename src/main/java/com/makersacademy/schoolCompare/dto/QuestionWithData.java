package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Question;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionWithData {
    private Question question;
    private String username;
    private Long likes;
    private boolean likedByCurrentUser;
    private LocalDateTime lastAnswerTimestamp;
    private List<AnswerWithData> answers;

    public QuestionWithData(Question question,
                            String username,
                            Long likes,
                            boolean likedByCurrentUser) {
        this.question = question;
        this.username = username;
        this.likes = likes;
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public QuestionWithData() {};

    public Question getQuestion() { return question; }
    public String getUsername() { return username; }
    public Long getLikes() { return likes; }
    public boolean isLikedByCurrentUser() { return likedByCurrentUser; }
    public LocalDateTime getLastAnswerTimestamp() { return lastAnswerTimestamp; }
    public List<AnswerWithData> getAnswers() { return answers; }

    // Extra getters:
    public Long getId() { return question.getId(); }
    public Long getSchoolId() { return question.getSchoolId(); }
    public Long getUserId() { return question.getUserId(); }
    public String getContent() { return question.getContent(); }
    public LocalDateTime getCreatedAt() { return question.getCreatedAt(); }

    public void setQuestion(Question question) { this.question = question; }
    public void setUsername(String username) { this.username = username; }
    public void setLikes(Long likes) { this.likes = likes; }
    public void setLikedByCurrentUser(boolean likedByCurrentUser) { this.likedByCurrentUser = likedByCurrentUser; }
    public void setLastAnswerTimestamp(LocalDateTime lastAnswerTimestamp) { this.lastAnswerTimestamp = lastAnswerTimestamp; }
    public void setAnswers(List<AnswerWithData> answers) { this.answers = answers; }
}