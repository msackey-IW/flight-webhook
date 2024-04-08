package com.example.webhook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webhook.domain.Webhook;
import com.example.webhook.repository.WebhookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WebhookServiceImpl implements WebhookService {
    
    @Autowired
    private WebhookRepository webhookRepository;

    @Autowired
    private WebhookExecutionService webhookExecutionService;

    public void registerWebhook(String url) {
        webhookRepository.save(new Webhook(url));
    }

    public void updateWebhook(Long webhookId, String newUrl) {
        Webhook webhook = webhookRepository.findById(webhookId).orElse(null);
        if (webhook == null) {
            throw new EntityNotFoundException("Webhook not found");
        }
        else{
            webhookRepository.delete(webhook);
            webhook.setUrl(newUrl);
            webhookRepository.save(webhook);
        }
    }

    public void triggerUpdate(Long webhookId, String payload) {
        Webhook webhook = webhookRepository.findById(webhookId).orElse(null);
        if (webhook == null) {
            throw new EntityNotFoundException("Webhook not found");
        }
        webhookExecutionService.executeWebhook(webhook, payload);
    }

    public List<Webhook> getAllWebhooks() {
        List<Webhook> webhooks = new ArrayList<Webhook>();
        webhookRepository.findAll().forEach(webhooks::add);
        return webhooks;
    }
    
    public void deleteWebhook(Long id){
        Webhook webhook = webhookRepository.findById(id).orElse(null);
        if (webhook == null) {
            throw new EntityNotFoundException("Webhook not found");
        }
        else {
            webhookRepository.delete(webhook);
        }
    }
}
