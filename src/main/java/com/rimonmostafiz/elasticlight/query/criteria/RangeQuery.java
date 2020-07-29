package com.rimonmostafiz.elasticlight.query.criteria;

import com.rimonmostafiz.elasticlight.query.Argument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rimon Mostafiz
 */
@Data
public class RangeQuery implements CriteriaQuery {
    private final Map<String, Argument> range;

    public RangeQuery() {
        this.range = new HashMap<>();
    }

    public RangeQuery(String field, Argument arg) {
        this();
        this.range.put(field, arg);
    }
}
