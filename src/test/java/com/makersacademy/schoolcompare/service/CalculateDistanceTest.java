package com.makersacademy.schoolcompare.service;

import com.makersacademy.schoolcompare.pojo.CalculateDistance;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@ActiveProfiles("test")
public class CalculateDistanceTest {
    @Test
    public void calculatesCorrectDistance() {
        BigDecimal latA = BigDecimal.valueOf(53.32055555555556);
        BigDecimal lngA = BigDecimal.valueOf(-1.7297222222222221);
        BigDecimal latB = BigDecimal.valueOf(53.31861111111111);
        BigDecimal lngB = BigDecimal.valueOf(-1.6997222222222223);

        double distance = CalculateDistance.fromLatLng(latA, lngA, latB, lngB);
        double expectedDistance = 1.244589415822132;
        Assert.assertEquals(expectedDistance, distance, 0.000001);
    }
}
