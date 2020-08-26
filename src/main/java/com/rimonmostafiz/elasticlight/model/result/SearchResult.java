package com.rimonmostafiz.elasticlight.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rimon Mostafiz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult<T> {
    @JsonProperty("_shards")
    private Shards shards;
    private Hits<T> hits;
    private Integer took;
    @JsonProperty("timed_out")
    private boolean timedOut;
}
