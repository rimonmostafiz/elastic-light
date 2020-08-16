package com.rimonmostafiz.elasticlight.core;

import com.rimonmostafiz.elasticlight.query.Query;
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
    }

    public static Command of(Verb verb, String path, String body, Head head) {
        Command command = new Command();
        command.setVerb(verb);
        command.setPath(path);
        command.setBody(body);
        command.setHead(head);
        return command;
    }

    public static Command of(Verb verb, String path, Query query, Head head) {
        Command command = new Command();
        command.setVerb(verb);
        command.setPath(path);
        command.setBody(query.toString());
        command.setHead(head);
        return command;
    }
}
