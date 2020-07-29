package com.rimonmostafiz.elasticlight.query.bool;

import com.rimonmostafiz.elasticlight.query.builder.TermQueryBuilder;
import com.rimonmostafiz.elasticlight.query.criteria.CriteriaQuery;
import com.rimonmostafiz.elasticlight.query.criteria.TermQuery;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rimon Mostafiz
 */
@Data
public class Should implements BooleanQuery {
    public List<CriteriaQuery> should;

    public Should() {
        this.should = new ArrayList<>();
    }

    public Should(List<CriteriaQuery> criteriaQueries) {
        this();
        this.should.addAll(criteriaQueries);
    }

    public Should addTerm(TermQuery termQuery) {
        this.should.add(termQuery);
        return this;
    }

    public Should addTerm(TermQueryBuilder termQueryBuilder) {
        TermQuery termQuery = termQueryBuilder.build();
        return this.addTerm(termQuery);
    }
}
