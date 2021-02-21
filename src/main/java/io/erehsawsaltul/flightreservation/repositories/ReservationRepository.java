package io.erehsawsaltul.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.erehsawsaltul.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
