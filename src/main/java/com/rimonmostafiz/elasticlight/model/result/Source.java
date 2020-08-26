package com.rimonmostafiz.elasticlight.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rimon Mostafiz
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Source<T> {
    T obj;
}
