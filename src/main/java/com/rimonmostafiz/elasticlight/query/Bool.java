package com.rimonmostafiz.elasticlight.query;

import com.rimonmostafiz.elasticlight.query.bool.BooleanQuery;

/**
 * @author Rimon Mostafiz
 */
public class Bool {
    BooleanQuery bool;

    public Bool(BooleanQuery booleanQuery) {
        this.bool = booleanQuery;
    }
}
