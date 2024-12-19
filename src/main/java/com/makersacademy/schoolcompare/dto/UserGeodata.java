package com.makersacademy.schoolcompare.dto;

import java.math.BigDecimal;

public class UserGeodata {
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public UserGeodata(String address, BigDecimal latitude, BigDecimal longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UserGeodata() {}

    public String getAddress() { return address; }
    public BigDecimal getLatitude() { return latitude; }
    public BigDecimal getLongitude() { return longitude; }

    public void setAddress(String address) { this.address = address; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
}
