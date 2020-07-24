package com.rimonmostafiz.elasticlight.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rimon Mostafiz
 */
@SpringBootTest
class RestConfigTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    void restTemplateShouldNotNull() {
        Assertions.assertNotNull(restTemplate);
    }
}