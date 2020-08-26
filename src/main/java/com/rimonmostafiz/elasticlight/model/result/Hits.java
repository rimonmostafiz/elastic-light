package com.rimonmostafiz.elasticlight.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Rimon Mostafiz
 */
@Data
@ToString
@NoArgsConstructor
public class Hits<T> {
    @JsonProperty("hits")
    private List<EsHit<T>> esHits;
}
