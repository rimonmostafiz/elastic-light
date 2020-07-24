package com.rimonmostafiz.elasticlight.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Rimon Mostafiz
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(@Value("${elastic-light.elasticsearch.rest.uris}") String defaultUris,
                                     @Value("${elastic-light.rest-template.read.timeout}") int readTimeOut,
                                     @Value("${elastic-light.rest-template.connect.timeout}") int connectTimeOut) {
        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defUriBuilder = new DefaultUriBuilderFactory(defaultUris);

        SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        rf.setReadTimeout((int) TimeUnit.SECONDS.toMillis(readTimeOut));
        rf.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(connectTimeOut));
        restTemplate.setRequestFactory(rf);
        restTemplate.setUriTemplateHandler(defUriBuilder);
        return restTemplate;
    }
}
