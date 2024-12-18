package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.pojo.TimeAgo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionWithData {
    private Long id;
    private Question question;
    private String content;
    private String username;
    private Long likes;
    private boolean likedByCurrentUser;
    private LocalDateTime lastAnswerTimestamp;
    private List<AnswerWithData> answers = new ArrayList<>();
    private Long answerCount;
    private AnswerWithData bestAnswer;
    private LocalDateTime createdAt;


    public QuestionWithData(Long id, Question question, String username, String content, Long likes, Long answerCount, LocalDateTime lastAnswerTimestamp, boolean likedByCurrentUser) {
        this.id = id;
        this.question = question;
        this.username = username;
        this.content = content;
        this.likes = likes;
        this.answerCount = answerCount;
        this.lastAnswerTimestamp = lastAnswerTimestamp;
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public QuestionWithData() {};

    public Question getQuestion() { return question; }
    public String getUsername() { return username; }
    public Long getLikes() { return likes; }
    public boolean isLikedByCurrentUser() { return likedByCurrentUser; }
    public LocalDateTime getLastAnswerTimestamp() { return lastAnswerTimestamp; }
    public List<AnswerWithData> getAnswers() { return answers; }
    public AnswerWithData getBestAnswer() {return  bestAnswer; }


    // Extra getters:
    public Long getId() { return this.id; }
    public Long getSchoolId() { return question.getSchoolId(); }
    public Long getUserId() { return question.getUserId(); }

    public String getTimeAgo() {
        return (question != null && question.getCreatedAt() != null)
                ? TimeAgo.calculate(question.getCreatedAt())
                : "N/A";
    }    public void setTimeAgo(String timeAgo) {
    }

    public void setQuestion(Question question) { this.question = question; }
    public void setUsername(String username) { this.username = username; }
    public void setLikes(Long likes) { this.likes = likes; }
    public void setLikedByCurrentUser(boolean likedByCurrentUser) { this.likedByCurrentUser = likedByCurrentUser; }
    public void setLastAnswerTimestamp(LocalDateTime lastAnswerTimestamp) { this.lastAnswerTimestamp = lastAnswerTimestamp; }
    public void setAnswers(List<AnswerWithData> answers) { this.answers = answers; }
    public void setBestAnswer(AnswerWithData bestAnswer) { this.bestAnswer = bestAnswer; }

    public void setId(Long id) { this.id = id; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }
}