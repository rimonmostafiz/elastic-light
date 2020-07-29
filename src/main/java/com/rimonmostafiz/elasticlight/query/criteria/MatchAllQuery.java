package com.rimonmostafiz.elasticlight.query.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rimonmostafiz.elasticlight.query.Argument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rimon Mostafiz
 */
@Data
public class MatchAllQuery implements CriteriaQuery {
    @JsonProperty("match_all")
    private Map<String, Argument> matchAll;

    public MatchAllQuery() {
        this.matchAll = new HashMap<>();
    }
}
