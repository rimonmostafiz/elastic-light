package com.rimonmostafiz.elasticlight.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
@AllArgsConstructor
public class Command {
    private Verb verb;
    private String path;
    private String body;
    private Head head;

    public Command() {
        this.path = "";
        this.verb = Verb.GET;
        this.head = Head.JSON;
    }
}
