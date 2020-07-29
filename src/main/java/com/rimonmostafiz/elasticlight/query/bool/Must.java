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
public class Must implements BooleanQuery {
    private List<CriteriaQuery> must;

    public Must() {
        this.must = new ArrayList<>();
    }

    public Must(List<CriteriaQuery> criteriaQueries) {
        this();
        this.must.addAll(criteriaQueries);
    }

    public Must addTerm(TermQuery termQuery) {
        this.must.add(termQuery);
        return this;
    }

    public Must addTerm(TermQueryBuilder termQueryBuilder) {
        TermQuery termQuery = termQueryBuilder.build();
        return this.addTerm(termQuery);
    }
}
