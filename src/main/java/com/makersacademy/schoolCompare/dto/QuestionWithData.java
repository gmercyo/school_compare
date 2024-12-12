package com.makersacademy.schoolCompare.dto;

import java.time.LocalDateTime;

public class QuestionWithData {
    private Long id;
    private String userId;
    private String username;
    private Long schoolId;
    private Long postId;
    private String content;
    private LocalDateTime createdAt;

    public QuestionWithData(Long id, String userId, String username, Long schoolId,Long postId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.schoolId = schoolId;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public QuestionWithData() {};


}
