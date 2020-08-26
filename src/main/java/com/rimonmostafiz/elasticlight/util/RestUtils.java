package com.rimonmostafiz.elasticlight.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rimonmostafiz.elasticlight.component.EsParameterizedType;
import com.rimonmostafiz.elasticlight.model.result.SearchResult;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * @author Rimon Mostafiz
 */
@RequiredArgsConstructor
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

    public static <T> SearchResult<T> extractSearchResult(String result, Class<T> klass, ObjectMapper objectMapper)
            throws Exception {
        TypeReference<SearchResult<T>> typeReference = new TypeReference<SearchResult<T>>() {
            @Override
            public Type getType() {
                return new EsParameterizedType((ParameterizedType) super.getType(), new Type[]{klass});
            }
        };
        JsonNode hits = objectMapper.readTree(result);
        return objectMapper.convertValue(hits, typeReference);
    }

    public static <T> List<T> extractObjectList(SearchResult<T> searchResult) {
        List<T> list = new java.util.ArrayList<>(Collections.emptyList());
        searchResult.getHits().getEsHits().forEach(e -> list.add(e.getSource()));
        return list;
    }
}
