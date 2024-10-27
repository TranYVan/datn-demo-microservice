package com.datn_microservices.order_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestService {

    @Autowired
    private final RestTemplate restTemplate;

    public HttpRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object sendGetRequest(String url) {

        Object response = restTemplate.getForObject(url, Object.class);
        System.out.println(response.toString());
        return null;
    }

    public String sendPutRequest(String url, Object object) {
        restTemplate.put(url, object);
        return "Response";
    }
}
