package com.makersacademy.schoolcompare.model;

import org.flywaydb.core.Flyway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@ActiveProfiles("test")
@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
public class AnswerTest {
    @Autowired
    private Flyway flyway;

    @BeforeEach
    void setUpDatabase() {
        flyway.clean();
        flyway.migrate();
    }

    @AfterEach
    void cleanDatabase() {flyway.clean(); }

    @Test
    public void createAnswerWithNoParams(){
        Long schoolId = 1L;
        com.makersacademy.schoolcompare.model.Answer answer = new Answer();
        answer.setSchoolId(schoolId);
        Assert.assertEquals(schoolId, answer.getSchoolId());
    }

    @Test
    public void createAnswerWithAllParams() {
        Long schoolId = 1L;
        Long userId = 1L;
        Long questionId = 1L;
        String role = "role";
        String content = "Test Content";
        LocalDateTime createdAt = LocalDateTime.of(2024, 12, 19, 11, 8, 0, 0);
        Answer answer = new Answer(
                schoolId,
                userId,
                questionId,
                role,
                content,
                createdAt
        );
        Assert.assertEquals(schoolId, answer.getSchoolId());
    }

    @Test
    public void createAnswerWithNullParams() {
        Long schoolId = 1L;
        Long userId = null;
        Long questionId = 1L;
        String role = null;
        String content = "Test Content";
        LocalDateTime createdAt = null;
        Answer answer = new Answer(
                schoolId,
                userId,
                questionId,
                role,
                content,
                createdAt
        );
        Assert.assertEquals(schoolId, answer.getSchoolId());
    }

}
