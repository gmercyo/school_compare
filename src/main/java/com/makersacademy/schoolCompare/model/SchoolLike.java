package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.SchoolLikeId;
import jakarta.persistence.*;

@Entity
@Table(name="SCHOOL_LIKES")
@IdClass(SchoolLikeId.class)
public class SchoolLike {
    @Id
    @JoinColumn(name = "user_id")
    private Long userId;
    @Id
    @JoinColumn(name = "school_id")
    private Long schoolId;

    public SchoolLike(Long userId, Long schoolId) {
        this.userId = userId;
        this.schoolId = schoolId;
    }

    public SchoolLike() {}

    public Long getUserId() { return userId; }
    public Long getSchoolId() { return schoolId; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setSchoolId(Long schoolId) { this.schoolId = schoolId; }
}