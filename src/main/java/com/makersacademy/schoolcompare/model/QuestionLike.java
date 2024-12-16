package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.QuestionLikeId;
import jakarta.persistence.*;

@Entity
@Table(name="QUESTION_LIKES")
@IdClass(QuestionLikeId.class)
public class QuestionLike {
    @Id
    @JoinColumn(name = "user_id")
    private Long userId;
    @Id
    @JoinColumn(name = "question_id")
    private Long questionId;

    public QuestionLike(Long userId, Long questionId) {
        this.userId = userId;
        this.questionId = questionId;
    }

    public QuestionLike() {}

    public Long getUserId() { return userId; }
    public Long getQuestionId() { return questionId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
}