package com.example.webhook.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import com.example.webhook.domain.Webhook;

@Service
public class WebhookExecutionServiceImpl implements WebhookExecutionService {
    @Autowired
    private RestTemplate restTemplate;

    public void executeWebhook(Webhook webhook, String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        restTemplate.postForObject(webhook.getUrl(), request, String.class);
    }
}   