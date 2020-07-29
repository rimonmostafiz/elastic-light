package com.rimonmostafiz.elasticlight.query.builder;

import com.rimonmostafiz.elasticlight.query.Argument;
import com.rimonmostafiz.elasticlight.query.criteria.TermQuery;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class TermQueryBuilder {
    private TermQuery termQuery;

    public TermQueryBuilder() {
        this.termQuery = new TermQuery();
    }

    public TermQueryBuilder(String field, String value) {
        this.termQuery = new TermQuery(field, value);
    }

    public static TermQueryBuilder termQuery(String field, String value) {
        return new TermQueryBuilder(field, value);
    }

    public TermQueryBuilder forField(String field) {
        this.termQuery.setField(field);
        this.termQuery.getTerm().put(field, new Argument());
        return this;
    }

    public TermQueryBuilder withValue(String value) {
        this.termQuery.getTerm().put(this.termQuery.getField(), new Argument(value));
        return this;
    }

    public TermQuery build() {
        return this.termQuery;
    }
}
