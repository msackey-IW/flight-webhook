package com.example.webhook.service;

import java.util.List;
import com.example.webhook.domain.Flight;


public interface FlightService {
    public List<Flight> getAllFlights();
    public void addOrUpdateFlight(Flight flight);
} 
