package com.rimonmostafiz.elasticlight.core;

import com.rimonmostafiz.elasticlight.query.Query;

/**
 * @author Rimon Mostafiz
 */
public class CommandBuilder {
    private final Command command;

    public CommandBuilder() {
        this.command = new Command();
    }

    public CommandBuilder withVerb(Verb verb) {
        this.command.setVerb(verb);
        return this;
    }

    public CommandBuilder withPath(String path) {
        this.command.setPath(path);
        return this;
    }

    public CommandBuilder withQuery(String query) {
        this.command.setBody(query);
        return this;
    }

    public CommandBuilder withQuery(Query query) {
        this.command.setBody(query.toString());
        return this;
    }

    public CommandBuilder withHead(Head head) {
        this.command.setHead(head);
        return this;
    }

    public Command build() {
        return this.command;
    }
}
