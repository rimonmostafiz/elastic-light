package com.rimonmostafiz.elasticlight.core;

import lombok.AllArgsConstructor;

/**
 * @author Rimon Mostafiz
 */
@AllArgsConstructor
public enum Head {
    JSON("application/json"),
    ND_JSON("application/ndjson");

    public String value;
}
