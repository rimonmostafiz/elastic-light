package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Bool;
import com.rimonmostafiz.elasticlight.query.Query;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class RootQueryBuilder {
    private final Query query;

    public RootQueryBuilder() {
        this.query = new Query();
    }

    public RootQueryBuilder withBool(Bool bool) {
        this.query.setQuery(bool);
        return this;
    }

    public Query build() {
        return this.query;
    }
}
