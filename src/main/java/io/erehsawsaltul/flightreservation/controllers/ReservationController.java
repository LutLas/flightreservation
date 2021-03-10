package io.erehsawsaltul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.erehsawsaltul.flightreservation.entities.Flight;
import io.erehsawsaltul.flightreservation.repositories.FlightRepository;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Integer flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).orElseThrow();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
}
