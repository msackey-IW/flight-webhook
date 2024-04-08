package com.example.webhook.repository;
import com.example.webhook.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    
}
