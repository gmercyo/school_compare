package com.makersacademy.schoolcompare.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;

    // One-to-many relationship with Review, as a user can have multiple reviews
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "savedByUsers")
    private List<School> savedSchools = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ReviewUpvote> reviewUpvotes;


    public User(String username, String auth0Id, String address, BigDecimal latitude, BigDecimal longitude) {
        this.username = username;
        this.auth0Id = auth0Id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User() {
    }


    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<School> getSavedSchools() {
        return savedSchools;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public void setSavedSchools(List<School> savedSchools) {
        this.savedSchools = savedSchools;
    }

}


