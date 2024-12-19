package com.makersacademy.schoolcompare.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AnswerUpvote {

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "answer_id", insertable = false, updatable = false)
    private Long answerId;

    public AnswerUpvote(Long userId, Long answerId) {
        this.userId = userId;
        this.answerId = answerId;
    }

    public AnswerUpvote() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}
