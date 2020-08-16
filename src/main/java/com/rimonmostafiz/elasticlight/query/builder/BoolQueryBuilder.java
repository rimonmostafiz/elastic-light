package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Bool;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class BoolQueryBuilder {
    private Bool bool;

    private BoolQueryBuilder() {
        this.bool = new Bool();
    }

    public BoolQueryBuilder(ShouldQueryBuilder shouldBuilder) {
        this.bool = new Bool(shouldBuilder.getShould());
    }

    public BoolQueryBuilder(MustQueryBuilder mustBuilder) {
        this.bool = new Bool(mustBuilder.getMust());
    }

    public static BoolQueryBuilder of(ShouldQueryBuilder shouldQueryBuilder) {
        return new BoolQueryBuilder(shouldQueryBuilder);
    }

    public static BoolQueryBuilder of(MustQueryBuilder mustQueryBuilder) {
        return new BoolQueryBuilder(mustQueryBuilder);
    }

    public Bool build() {
        return this.bool;
    }
}
