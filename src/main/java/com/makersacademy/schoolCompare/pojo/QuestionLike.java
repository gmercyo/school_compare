
package com.makersacademy.schoolcompare.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class QuestionLike {
    @Column(name = "user_id", insertable=false, updatable=false)
    private Long userId;
    @Column(name = "question_id", insertable=false, updatable=false)
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