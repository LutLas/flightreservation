package io.erehsawsaltul.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.erehsawsaltul.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
