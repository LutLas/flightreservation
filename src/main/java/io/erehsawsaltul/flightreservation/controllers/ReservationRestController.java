package io.erehsawsaltul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.erehsawsaltul.flightreservation.dto.UpdateReservationRequest;
import io.erehsawsaltul.flightreservation.entities.Reservation;
import io.erehsawsaltul.flightreservation.repositories.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Integer id) {
		return reservationRepository.findById(id).orElseThrow();
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).orElseThrow();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}
}
