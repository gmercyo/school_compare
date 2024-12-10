package com.makersacademy.schoolCompare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double catchmentRadius; // in kilometers or miles

    @Column
    private String ofstedRating;

    @Column
    private String ofstedUrl;

    @Column(nullable = false)
    private String type; // e.g., primary, secondary, etc.

    @Column(nullable = false)
    private String gender; // e.g., mixed, boys, girls

    @Column(nullable = false)
    private Boolean senAvailability; // Special Educational Needs availability

    @Column
    private String religiousAffiliation; // e.g., Christian, Muslim, None

    @Column
    private String website; // Official website URL of the school

    // Constructors
    public School() {}

    public School(String name, String address, Double latitude, Double longitude, Double catchmentRadius,
                  String ofstedRating, String ofstedUrl, String type, String gender, Boolean senAvailability,
                  String religiousAffiliation, String website) {

        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.catchmentRadius = catchmentRadius;
        this.ofstedRating = ofstedRating;
        this.ofstedUrl = ofstedUrl;
        this.type = type;
        this.gender = gender;
        this.senAvailability = senAvailability;
        this.religiousAffiliation = religiousAffiliation;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getCatchmentRadius() {
        return catchmentRadius;
    }

    public void setCatchmentRadius(Double catchmentRadius) {
        this.catchmentRadius = catchmentRadius;
    }

    public String getOfstedRating() {
        return ofstedRating;
    }

    public void setOfstedRating(String ofstedRating) {
        this.ofstedRating = ofstedRating;
    }

    public String getOfstedUrl() {
        return ofstedUrl;
    }

    public void setOfstedUrl(String ofstedUrl) {
        this.ofstedUrl = ofstedUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getSenAvailability() {
        return senAvailability;
    }

    public void setSenAvailability(Boolean senAvailability) {
        this.senAvailability = senAvailability;
    }

    public String getReligiousAffiliation() {
        return religiousAffiliation;
    }

    public void setReligiousAffiliation(String religiousAffiliation) {
        this.religiousAffiliation = religiousAffiliation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
