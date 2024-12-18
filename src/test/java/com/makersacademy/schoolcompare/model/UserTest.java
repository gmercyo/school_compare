package com.makersacademy.schoolcompare.model;


import org.flywaydb.core.Flyway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@ActiveProfiles("test")
@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
public class UserTest {
    @Autowired
    private Flyway flyway;

    @BeforeEach
    void setUpDatabase() {
        flyway.clean();
        flyway.migrate();
    }

    @AfterEach
    void cleanDatabase() { flyway.clean(); }

    @Test
    public void createUserWithNoParams() {
        String username = "Username123456789";
        com.makersacademy.schoolcompare.model.User user = new User();
        user.setUsername(username);
        Assert.assertEquals(username, user.getUsername());
    }

    @Test
    public void createUserWithAllParams() {
        String username = "Username123456789";
        String auth0Id = "ExampleAuth0Id";
        String address = "123 Street";
        BigDecimal latitude = BigDecimal.valueOf(54.71844);
        BigDecimal longitude = BigDecimal.valueOf(107.28340);
        User user = new User(username,auth0Id,address,latitude,longitude);
        user.setUsername(username);
        Assert.assertEquals(username, user.getUsername());
    }

    @Test
    public void createUserWithSomeNullParams(){
        String username = "Username123456789";
        String auth0Id = null;
        String address = "123 Street";
        BigDecimal latitude = null;
        BigDecimal longitude = null;
        User user = new User(username,auth0Id,address,latitude,longitude);
        Assert.assertEquals(username, user.getUsername());
    }


}
