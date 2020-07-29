package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.bool.Must;
import com.rimonmostafiz.elasticlight.query.bool.Should;
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

    public static MustQueryBuilder withTerm(TermQueryBuilder termQueryBuilder) {
        MustQueryBuilder builder = new MustQueryBuilder();
        builder.must.addTerm(termQueryBuilder);
        return builder;
    }

    public Must build() {
        return this.must;
    }
}
