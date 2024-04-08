package com.example.webhook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webhook.domain.Flight;
import com.example.webhook.domain.Webhook;
import com.example.webhook.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private WebhookServiceImpl webhookService;

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        flightRepository.findAll().forEach(flights::add);
        return flights;

    }

    public void addOrUpdateFlight(Flight flight) {
        // Implement logic to add or update a flight
        flightRepository.save(flight);

        // Trigger webhooks with the updated flight information
        List<Webhook> webhooks = webhookService.getAllWebhooks();
        String payload = "New flight information: " + flight.toString();

        for (Webhook webhook : webhooks) {
            webhookService.triggerUpdate(webhook.getId(), payload);
        }
    }
    

}
