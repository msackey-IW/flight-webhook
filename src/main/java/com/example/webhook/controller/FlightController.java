package com.example.webhook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webhook.domain.Flight;
import com.example.webhook.service.FlightServiceImpl;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @PostMapping
    public ResponseEntity<String> addOrUpdateFlight(@RequestBody Flight flight) {
        flightService.addOrUpdateFlight(flight);
        return ResponseEntity.ok("Flight added or updated successfully");
    }

    // Add other endpoints for flight management
}