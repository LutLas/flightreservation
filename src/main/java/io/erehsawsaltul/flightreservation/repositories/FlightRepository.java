package io.erehsawsaltul.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.erehsawsaltul.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
