package com.makersacademy.schoolcompare.pojo;

public class CatchmentRadius {
    private String year;
    private Float radius;

    public CatchmentRadius(String year, Float radius) {
        this.year = year;
        this.radius = radius;
    }

    public CatchmentRadius() {}

    public String getYear() { return year; }
    public Float getRadius() { return radius; }

    public void setYear(String year) { this.year = year; }
    public void setRadius(Float radius) { this.radius = radius; }
}
