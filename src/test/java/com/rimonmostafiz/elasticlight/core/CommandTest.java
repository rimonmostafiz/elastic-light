package com.rimonmostafiz.elasticlight.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Rimon Mostafiz
 */
@SpringBootTest
class CommandTest {

    private Command command;

    @BeforeEach
    public void before() {
        this.command = new Command();
    }

    @Test
    public void defaultValue() {
        Assertions.assertNotNull(command, "command null");

        Assertions.assertNotNull(this.command.getVerb(), "command.verb null");
        Assertions.assertEquals(command.getVerb(), Verb.GET, "command.verb is not GET");

        Assertions.assertNotNull(this.command.getPath(), "command.path null");
        Assertions.assertEquals(this.command.getPath(), "", "command.path not empty");

        Assertions.assertNull(this.command.getBody(), "command.body is not null");

        Assertions.assertNotNull(this.command.getHead(), "command.head is null");
        Assertions.assertEquals(this.command.getHead(), Head.JSON, "command.head is not JSON");
    }
}