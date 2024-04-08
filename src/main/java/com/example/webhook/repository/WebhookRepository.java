package com.example.webhook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webhook.domain.Webhook;

@Repository
public interface WebhookRepository extends CrudRepository<Webhook, Long> {
    
}
