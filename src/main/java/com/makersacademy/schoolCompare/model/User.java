package com.makersacademy.schoolCompare.model;

import jakarta.persistence.*;

import static java.lang.Boolean.TRUE;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, boolean enabled) {
        this.username = username;
    }
}
