package com.rimonmostafiz.elasticlight.query;

import com.rimonmostafiz.elasticlight.query.bool.BooleanQuery;
import com.rimonmostafiz.elasticlight.query.bool.Must;
import com.rimonmostafiz.elasticlight.query.bool.Should;
import lombok.Data;

/**
 * @author Rimon Mostafiz
 */
@Data
public class Bool {
    BooleanQuery bool;

    public Bool() {
    }

    public Bool(BooleanQuery booleanQuery) {
        this.bool = booleanQuery;
    }

    public Bool(Must must) {
        if (this.bool == null) this.bool = must;
    }

    public Bool(Should should) {
        if (this.bool == null) this.bool = should;
    }

    public static Bool withMust(Must must) {
        return new Bool(must);
    }

    public static Bool withShould(Should should) {
        return new Bool(should);
    }
}
