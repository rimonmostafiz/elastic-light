package com.rimonmostafiz.elasticlight.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

/**
 * @author Rimon Mostafiz
 */
public class RestUtils {
    private static final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public static String beanToPrettyJSON(Object o) {
        try {
            return ow.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            return "NOT JSON able";
        }
    }

    public static boolean isOkAndHasBody(ResponseEntity<String> responseEntity) {
        return responseEntity.getStatusCode().is2xxSuccessful() && StringUtils.isNotEmpty(responseEntity.getBody());
    }
}
