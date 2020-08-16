package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Query;
import com.rimonmostafiz.elasticlight.query.criteria.TermQuery;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class TermQueryBuilder {
    private TermQuery termQuery;

    private TermQueryBuilder(TermQuery termQuery) {
        this.termQuery = termQuery;
    }

    public static TermQueryBuilder of(String field, String value) {
        TermQuery termQuery = new TermQuery(field, value);
        return new TermQueryBuilder(termQuery);
    }

    public Query wrapWithMust() {
        MustQueryBuilder mqb = MustQueryBuilder.term(this);
        BoolQueryBuilder bqb = BoolQueryBuilder.of(mqb);
        return RootQueryBuilder.bool(bqb).build();
    }

    public Query wrapWithShould() {
        ShouldQueryBuilder sqb = ShouldQueryBuilder.withTerm(this);
        BoolQueryBuilder bqb = BoolQueryBuilder.of(sqb);
        return RootQueryBuilder.bool(bqb).build();
    }

    public TermQuery build() {
        return this.termQuery;
    }
}
