package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.AnswerUpvoteId;
import jakarta.persistence.*;

@Entity
@Table(name="ANSWER_UPVOTES")
@IdClass(AnswerUpvoteId.class)
public class AnswerUpvote {
    @Id
    @JoinColumn(name = "user_id")
    private Long userId;
    @Id
    @JoinColumn(name = "answer_id")
    private Long answerId;

    public AnswerUpvote(Long userId, Long answerId) {
        this.userId = userId;
        this.answerId = answerId;
    }

    public AnswerUpvote() {}

    public Long getUserId() { return userId; }
    public Long getAnswerId() { return answerId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setAnswerId(Long answerId) { this.answerId = answerId; }
}
