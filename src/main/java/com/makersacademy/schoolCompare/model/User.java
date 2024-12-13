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
    @Column(name = "auth0_id")
    private String auth0Id;

    public User(String username, String auth0Id) {
        this.username = username;
        this.auth0Id = auth0Id;
    }
    public User() {}

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getAuth0Id() { return auth0Id; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setAuth0Id(String auth0Id) { this.auth0Id = auth0Id; }
}