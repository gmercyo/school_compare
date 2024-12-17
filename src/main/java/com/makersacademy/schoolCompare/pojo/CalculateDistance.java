package com.makersacademy.schoolcompare.pojo;

import java.math.BigDecimal;

public class CalculateDistance {
    public static double fromLatLng(BigDecimal latA, BigDecimal lngA, BigDecimal latB, BigDecimal lngB)
    {
        // The math module contains a function named toRadians which converts from degrees to radians.
        double lat1 = Math.toRadians(latA.doubleValue());
        double lng1 = Math.toRadians(lngA.doubleValue());
        double lat2 = Math.toRadians(latB.doubleValue());
        double lng2 = Math.toRadians(lngB.doubleValue());

        // Haversine formula
        double dlng = lng2 - lng1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlng / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in miles
        double r = 3956;

        // calculate the result
        return(c * r);
    }
}
