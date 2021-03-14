package io.erehsawsaltul.flightreservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.erehsawsaltul.flightreservation.dto.ReservationRequest;
import io.erehsawsaltul.flightreservation.entities.Flight;
import io.erehsawsaltul.flightreservation.entities.Passenger;
import io.erehsawsaltul.flightreservation.entities.Reservation;
import io.erehsawsaltul.flightreservation.repositories.FlightRepository;
import io.erehsawsaltul.flightreservation.repositories.PassengerRepository;
import io.erehsawsaltul.flightreservation.repositories.ReservationRepository;
import io.erehsawsaltul.flightreservation.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment
		
		Integer flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).orElseThrow();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
