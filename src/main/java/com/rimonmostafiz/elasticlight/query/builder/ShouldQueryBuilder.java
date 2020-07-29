package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.bool.Should;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class ShouldQueryBuilder {
    private final Should should;

    public ShouldQueryBuilder() {
        this.should = new Should();
    }

    public static ShouldQueryBuilder withTerm(TermQueryBuilder termQueryBuilder) {
        ShouldQueryBuilder builder = new ShouldQueryBuilder();
        builder.should.addTerm(termQueryBuilder);
        return builder;
    }

    public Should build() {
        return this.should;
    }
}
