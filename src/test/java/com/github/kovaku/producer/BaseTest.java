package com.github.kovaku.producer;

import com.github.kovaku.producer.controller.FibonacciController;
import com.github.kovaku.producer.service.FibonacciService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    public void before() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }
}
