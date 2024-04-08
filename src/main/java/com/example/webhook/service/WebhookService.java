package com.example.webhook.service;

import java.util.List;
import com.example.webhook.domain.Webhook;


public interface WebhookService {
    public void registerWebhook(String url);
    public void updateWebhook(Long id, String newUrl);
    public void triggerUpdate(Long id, String payload);
    public List<Webhook> getAllWebhooks();
    public void deleteWebhook(Long id);

}
