package com.makersacademy.schoolCompare.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long school_id;
    private Long user_id;
    private String content;
    private LocalDateTime created_at;

    public Question() {}

    public Question(Long school_id, Long user_id, String content, LocalDateTime created_at) {
        this.school_id = school_id;
        this.user_id = user_id;
        this.content = content;
        this.created_at = created_at;

    }

    public Long getId() {
    return id;
    }

    public Long getSchool_id() {
    return school_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getContent(){
        return content;
    }

    public LocalDateTime getCreated_at(){
        return created_at;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setSchool_id(Long school_id){
        this.school_id = school_id;
    }

    public void setUser_id(Long user_id){
        this.user_id = user_id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setCreated_at(LocalDateTime created_at){
        this.created_at = created_at;
    }
}

