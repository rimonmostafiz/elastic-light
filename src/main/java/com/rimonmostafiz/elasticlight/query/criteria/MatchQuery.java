package com.rimonmostafiz.elasticlight.query.criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rimonmostafiz.elasticlight.query.Argument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rimon Mostafiz
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchQuery implements CriteriaQuery {
    private Map<String, Argument> match;
    @JsonIgnore
    private String field;

    public MatchQuery() {
        this.match = new HashMap<>();
    }

    public MatchQuery(String field, Argument arg) {
        this();
        this.match.put(field, arg);
    }

    public MatchQuery forField(String field) {
        this.field = field;
        this.match.put(field, new Argument());
        return this;
    }

    public MatchQuery withValue(String value) {
        this.match.put(this.getField(), new Argument(value));
        return this;
    }
}
