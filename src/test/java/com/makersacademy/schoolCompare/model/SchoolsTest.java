package com.makersacademy.schoolCompare.model;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
    void createSchool() {
        School school = new School();

    }
}
