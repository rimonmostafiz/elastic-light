package com.rimonmostafiz.elasticlight.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rimonmostafiz.elasticlight.core.Command;
import com.rimonmostafiz.elasticlight.model.result.SearchResult;
import com.rimonmostafiz.elasticlight.util.RestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Rimon Mostafiz
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticRestClient {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public <T> Optional<SearchResult<T>> searchRequest(Command c, Class<T> klass) throws Exception {
        log.debug("Command: {}", c);
        String uri = c.getPath();
        HttpMethod method = c.getVerb().resolve();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(c.getHead().value));
        HttpEntity<String> entity = new HttpEntity<>(c.getBody(), headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, method, entity, String.class);
        if (RestUtils.isOkAndHasBody(response)) {
            String body = response.getBody();
            log.debug("Response Body: {}", body);
            SearchResult<T> searchResult = RestUtils.extractSearchResult(body, klass, objectMapper);
            return Optional.ofNullable(searchResult);
        } else {
            return Optional.empty();
        }
    }

    public <T> List<T> requestForList(Command c, Class<T> klass) throws Exception {
        Optional<SearchResult<T>> searchResult = searchRequest(c, klass);
        return searchResult
                .map(RestUtils::extractObjectList)
                .orElseGet(Collections::emptyList);
    }
}
