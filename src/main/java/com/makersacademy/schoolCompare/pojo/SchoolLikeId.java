package com.makersacademy.schoolcompare.pojo;

import com.makersacademy.schoolcompare.model.SchoolLike;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SchoolLikeId {
    @Column(name = "user_id", insertable=false, updatable=false)
    private Long userId;
    @Column(name = "school_id", insertable=false, updatable=false)
    private Long schoolId;

    public SchoolLikeId(Long userId, Long schoolId) {
        this.userId = userId;
        this.schoolId = schoolId;
    }

    public SchoolLikeId() {}


    public Long getUserId() { return userId; }
    public Long getSchoolId() { return schoolId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setSchoolId(Long schoolId) { this.schoolId = schoolId; }
}