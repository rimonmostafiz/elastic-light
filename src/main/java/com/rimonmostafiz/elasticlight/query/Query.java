package com.rimonmostafiz.elasticlight.query;

import com.rimonmostafiz.elasticlight.util.RestUtils;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class Query {
    private Bool query;

    public Query() {
    }

    public Query(Bool bool) {
        this.query = bool;
    }

    @Override
    public String toString() {
        return RestUtils.beanToPrettyJSON(this);
    }
}
