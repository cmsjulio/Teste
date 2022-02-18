package com.devtalkers.restapitest;

import com.devtalkers.restapitest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/test.sql")
    public void getUserByIdTest(){

        ResponseEntity<User> response = testRestTemplate.getForEntity("/user/1001", User.class);

        assertEquals(1001, response.getBody().getId());
        assertEquals("John", response.getBody().getName());
        assertEquals("John@com.com", response.getBody().getEmail());
        assertEquals("987654321", response.getBody().getPhone());
        assertEquals("male", response.getBody().getGender());

    }

}
