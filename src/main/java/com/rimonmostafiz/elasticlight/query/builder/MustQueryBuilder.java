package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.bool.Must;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class MustQueryBuilder {
    private final Must must;

    public MustQueryBuilder() {
        this.must = new Must();
    }

    public static MustQueryBuilder term(TermQueryBuilder termQueryBuilder) {
        MustQueryBuilder mustQueryBuilder = new MustQueryBuilder();
        mustQueryBuilder.getMust().addTerm(termQueryBuilder);
        return mustQueryBuilder;
    }

    public Must build() {
        return this.must;
    }
}