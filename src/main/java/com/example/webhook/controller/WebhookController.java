package com.example.webhook.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.webhook.domain.Webhook;
import com.example.webhook.service.WebhookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/webhooks")
public class WebhookController {
    @Autowired
    private WebhookServiceImpl webhookService;

    @PostMapping("/subscribe")
    public ResponseEntity<String> registerWebhook(@RequestBody Webhook webhook) {
        webhookService.registerWebhook(webhook.getUrl());
        return ResponseEntity.ok("Webhook registered successfully");
    }
    @PostMapping("/unsubscribe/{id}")
    public ResponseEntity<String> deleteWebhook(@PathVariable Long webhookId) {
        webhookService.deleteWebhook(webhookId);
        return ResponseEntity.ok("Webhook registered deleted");
    }
}
