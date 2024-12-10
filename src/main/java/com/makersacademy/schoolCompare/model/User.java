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
<<<<<<< HEAD

    private boolean enabled;
=======
>>>>>>> 8de5d321d5902199913837f8a547f8192f02923f

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, boolean enabled) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
