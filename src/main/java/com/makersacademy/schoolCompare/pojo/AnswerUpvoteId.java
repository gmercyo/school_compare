package com.makersacademy.schoolcompare.pojo;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AnswerUpvoteId {
    @Column(name = "user_id", insertable=false, updatable=false)
    private Long userId;
    @Column(name = "answer_id", insertable=false, updatable=false)
    private Long answerId;

    public AnswerUpvoteId(Long userId, Long answerId) {
        this.userId = userId;
        this.answerId = answerId;
    }

    public AnswerUpvoteId() {}

    public Long getUserId() { return userId; }
    public Long getAnswerId() { return answerId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setAnswerId(Long answerId) { this.answerId = answerId; }
}