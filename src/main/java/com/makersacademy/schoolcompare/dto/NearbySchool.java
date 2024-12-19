package com.makersacademy.schoolcompare.dto;

import com.makersacademy.schoolcompare.pojo.CalculateDistance;

import java.math.BigDecimal;

public class NearbySchool {
    private Long id;
    private String name;
    private String address;
    private double distance;

    public NearbySchool(Long id, String name, String address, double distance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public NearbySchool() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getDistance() { return distance; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setDistance(double distance) { this.distance = distance; }
}
