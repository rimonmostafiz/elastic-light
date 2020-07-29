package com.rimonmostafiz.elasticlight.query.bool;

import com.rimonmostafiz.elasticlight.query.criteria.CriteriaQuery;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rimon Mostafiz
 */
@Data
public class Must {
    private List<CriteriaQuery> must;

    public Must() {
        this.must = new ArrayList<>();
    }

    public Must(List<CriteriaQuery> criteriaQueries) {
        this();
        this.must.addAll(criteriaQueries);
    }
}
