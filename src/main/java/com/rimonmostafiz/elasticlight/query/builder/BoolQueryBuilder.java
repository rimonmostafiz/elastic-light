package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Bool;
import com.rimonmostafiz.elasticlight.query.bool.Must;
import com.rimonmostafiz.elasticlight.query.bool.Should;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class BoolQueryBuilder {
    private Bool bool;

    public BoolQueryBuilder() {
        this.bool = new Bool();
    }

    public BoolQueryBuilder(ShouldQueryBuilder shouldBuilder) {
        Should should = shouldBuilder.getShould();
        this.bool = new Bool(should);
    }

    public BoolQueryBuilder(MustQueryBuilder mustBuilder) {
        Must must = mustBuilder.getMust();
        this.bool = new Bool(must);
    }

    public static BoolQueryBuilder withShould(ShouldQueryBuilder shouldQueryBuilder) {
        return new BoolQueryBuilder(shouldQueryBuilder);
    }

    public static BoolQueryBuilder withMust(MustQueryBuilder mustQueryBuilder) {
        return new BoolQueryBuilder();
    }

    public Bool build() {
        return this.bool;
    }
}
