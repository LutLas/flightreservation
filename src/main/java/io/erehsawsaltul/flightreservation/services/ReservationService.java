package io.erehsawsaltul.flightreservation.services;

import io.erehsawsaltul.flightreservation.dto.ReservationRequest;
import io.erehsawsaltul.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
