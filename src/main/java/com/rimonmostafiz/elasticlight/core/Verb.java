package com.rimonmostafiz.elasticlight.core;

import org.springframework.http.HttpMethod;

/**
 * @author Rimon Mostafiz
 */
public enum Verb {
    GET, POST, PUT, DELETE;

    public HttpMethod resolve() {
        return HttpMethod.resolve(this.name());
    }
}
