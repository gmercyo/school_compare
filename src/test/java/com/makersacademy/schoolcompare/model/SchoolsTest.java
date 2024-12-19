package com.makersacademy.schoolcompare.model;

import com.makersacademy.schoolcompare.pojo.CatchmentRadius;
import org.flywaydb.core.Flyway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
public class SchoolsTest {
    @Autowired
    private Flyway flyway;

    @BeforeEach
    void setUpDatabase() {
        flyway.clean();
        flyway.migrate();
    }

    @AfterEach
    void cleanDatabase() {
        flyway.clean();
    }

    @Test
    public void createSchoolWithNoParams() {
        String nameOfSchool = "Highbury School";
        School school = new School();
        school.setName(nameOfSchool);
        Assert.assertEquals(nameOfSchool, school.getName());
    }

    @Test
    public void createSchoolWithAllParams() {
        String name = "Fictional Highbury School";
        String address = "Highbury New Park, N5 2DP";
        BigDecimal latitude = BigDecimal.valueOf(51.554001);
        BigDecimal longitude = BigDecimal.valueOf(-0.091884);
        List<CatchmentRadius> catchmentRadiusList = Arrays.asList(
                new CatchmentRadius("'24-'25", 0.335F),
                new CatchmentRadius("'23-'24", 0.5F)
        );
        Integer ofstedRating = 3;
        String ofstedUrl = "https://files.ofsted.gov.uk/v1/file/50228420";
        String type = "primary";
        String gender = "mixed";
        String sen_availability = "n/a";
        String religious_affiliation = "community";
        String website = "https://example.com";
        School school = new School(
                name,
                address,
                latitude,
                longitude,
                catchmentRadiusList,
                ofstedRating,
                ofstedUrl,
                type,
                gender,
                sen_availability,
                religious_affiliation,
                website);
        Assert.assertEquals(name, school.getName());
    }

    @Test
    public void createSchoolWithSomeNullParams() {
        String name = "Fictional Highbury School";
        String address = "Highbury New Park, N5 2DP";
        BigDecimal latitude = null;
        BigDecimal longitude = null;
        List<CatchmentRadius> catchmentRadiusList = null;
        Integer ofstedRating = null;
        String ofstedUrl = null;
        String type = "primary";
        String gender = "mixed";
        String sen_availability = "n/a";
        String religious_affiliation = "community";
        String website = null;
        School school = new School(
                name,
                address,
                latitude,
                longitude,
                catchmentRadiusList,
                ofstedRating,
                ofstedUrl,
                type,
                gender,
                sen_availability,
                religious_affiliation,
                website);
        Assert.assertEquals(name, school.getName());
    }
}
