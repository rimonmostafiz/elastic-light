package com.rimonmostafiz.elasticlight.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rimon Mostafiz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shards {
    private Integer total;
    private Integer failed;
    private Integer successful;
    private Integer skipped;
}
