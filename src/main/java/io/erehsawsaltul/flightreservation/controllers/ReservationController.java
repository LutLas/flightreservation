package io.erehsawsaltul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.erehsawsaltul.flightreservation.dto.ReservationRequest;
import io.erehsawsaltul.flightreservation.entities.Flight;
import io.erehsawsaltul.flightreservation.entities.Reservation;
import io.erehsawsaltul.flightreservation.repositories.FlightRepository;
import io.erehsawsaltul.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Integer flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).orElseThrow();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value = "/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation "+reservation.getId()+" Created Successfully");
		
		return "reservationConfirmaiton";	
	}
	
}
