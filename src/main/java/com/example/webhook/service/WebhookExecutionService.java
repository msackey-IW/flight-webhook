package com.example.webhook.service;


import com.example.webhook.domain.Webhook;


public interface WebhookExecutionService {
    public void executeWebhook(Webhook webhook, String payload);
}
