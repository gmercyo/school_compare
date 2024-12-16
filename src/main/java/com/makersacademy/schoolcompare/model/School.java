package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.CatchmentRadius;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "schools")
public final class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<CatchmentRadius> catchmentRadius;

    @Column
    private Integer ofstedRating;

    @Column
    private String ofstedUrl;

    @Column
    private String type;

    @Column
    private String gender;

    @Column
    private String senAvailability;

    @Column
    private String religiousAffiliation;

    @Column
    private String website;

    // Constructors
    public School() {}

    public School(String name, String address, BigDecimal latitude, BigDecimal longitude, List<CatchmentRadius> catchmentRadius,
                  Integer ofstedRating, String ofstedUrl, String type, String gender, String senAvailability,
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public List<CatchmentRadius> getCatchmentRadius() {
        return catchmentRadius;
    }

    public void setCatchmentRadius(List<CatchmentRadius> catchmentRadius) {
        this.catchmentRadius = catchmentRadius;
    }

    public Integer getOfstedRating() {
        return ofstedRating;
    }

    public void setOfstedRating(Integer ofstedRating) {
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

    public String getSenAvailability() {
        return senAvailability;
    }

    public void setSenAvailability(String senAvailability) {
        this.senAvailability = senAvailability;
    }

    public String getReligiousAffiliation() {
        return religiousAffiliation;
    }

    public void setReligiousAffiliation(String religiousAffiliation) { this.religiousAffiliation = religiousAffiliation; }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
