package com.makersacademy.schoolcompare.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

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

    public User(String username, String auth0Id, String address, BigDecimal latitude, BigDecimal longitude) {
        this.username = username;
        this.auth0Id = auth0Id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public User() {}

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getAuth0Id() { return auth0Id; }
    public String getAddress() { return address; }
    public BigDecimal getLatitude() { return latitude; }
    public BigDecimal getLongitude() { return longitude; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setAuth0Id(String auth0Id) { this.auth0Id = auth0Id; }
    public void setAddress(String address) { this.address = address; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
}