package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Query;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class RootQueryBuilder {
    private Query query;

    private RootQueryBuilder() {
        this.query = new Query();
    }

    public static RootQueryBuilder bool(BoolQueryBuilder boolQueryBuilder) {
        RootQueryBuilder rootQueryBuilder = new RootQueryBuilder();
        rootQueryBuilder.getQuery().setQuery(boolQueryBuilder.getBool());
        return rootQueryBuilder;
    }

    public Query build() {
        return this.query;
    }
}
