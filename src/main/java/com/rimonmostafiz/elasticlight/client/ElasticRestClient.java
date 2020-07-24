package com.rimonmostafiz.elasticlight.client;

import com.rimonmostafiz.elasticlight.core.Command;
import com.rimonmostafiz.elasticlight.util.RestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rimon Mostafiz
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticRestClient {
    private final RestTemplate restTemplate;

    String request(Command c) {
        String uri = c.getPath();
        HttpMethod method = c.getVerb().resolve();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(c.getHead().value));
        HttpEntity<String> entity = new HttpEntity<>(c.getBody(), headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, method, entity, String.class);
        if (RestUtils.isOkAndHasBody(response)) {
            return response.getBody();
        } else {
            return "";
        }
    }
}
