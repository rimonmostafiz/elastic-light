package com.rimonmostafiz.elasticlight.query.criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rimonmostafiz.elasticlight.query.Argument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rimon Mostafiz
 */
@Data
public class TermQuery implements CriteriaQuery {
    @JsonIgnore
    private String field;
    private Map<String, Argument> term;

    public TermQuery() {
        this.term = new HashMap<>();
    }

    public TermQuery(String field, String value) {
        this();
        this.term.put(field, new Argument(value));
    }

    public static TermQuery term(String field, String value) {
        return new TermQuery(field, value);
    }
}