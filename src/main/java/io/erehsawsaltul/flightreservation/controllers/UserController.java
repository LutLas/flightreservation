package io.erehsawsaltul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.erehsawsaltul.flightreservation.entities.User;
import io.erehsawsaltul.flightreservation.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/logIn";
	}


	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, ModelMap userDetails) {
		if (user.getEmail().isBlank()) {

			userDetails.addAttribute("firstName", user.getFirstName());
			userDetails.addAttribute("lastName", user.getLastName());
			userDetails.addAttribute("password", user.getPassword());
			userDetails.addAttribute("confirmPassword", user.getConfirmPassword());

			userDetails.addAttribute("emailError", "Invalid Email");
			return showRegistrationPage();

		} else if (user.getPassword().isBlank()) {

			userDetails.addAttribute("firstName", user.getFirstName());
			userDetails.addAttribute("lastName", user.getLastName());
			userDetails.addAttribute("firstName", user.getFirstName());
			userDetails.addAttribute("email", user.getEmail());

			userDetails.addAttribute("passwordError", "Invalid Password");
			return showRegistrationPage();

		} else if (!user.getPassword().contentEquals(user.getConfirmPassword())) {

			userDetails.addAttribute("firstName", user.getFirstName());
			userDetails.addAttribute("lastName", user.getLastName());
			userDetails.addAttribute("firstName", user.getFirstName());
			userDetails.addAttribute("email", user.getEmail());
			userDetails.addAttribute("password", user.getPassword());

			userDetails.addAttribute("passwordMissedError", "Passwords Don't Match");
			return showRegistrationPage();

		}else {
			try {
				userRepository.save(user);
			} catch (Exception e) {
				
				userDetails.addAttribute("firstName", user.getFirstName());
				userDetails.addAttribute("lastName", user.getLastName());
				userDetails.addAttribute("firstName", user.getFirstName());
				userDetails.addAttribute("password", user.getPassword());
				userDetails.addAttribute("confirmPassword", user.getConfirmPassword());
				
				userDetails.addAttribute("error", e.getCause().getCause().getMessage());
				return showRegistrationPage();
				}
			
			userDetails.addAttribute("firstName", "");
			userDetails.addAttribute("lastName", "");
			userDetails.addAttribute("firstName", "");
			userDetails.addAttribute("email", "");
			userDetails.addAttribute("password", "");
			
			return "login/logIn";
		} 	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showLoginPage(@ModelAttribute("user") User user, ModelMap userDetails) {
		User fetchedUser = userRepository.findByEmail(user.getEmail());
		if(fetchedUser == null) {
			userDetails.addAttribute("emailLoginError", "Email Not Found");
			userDetails.addAttribute("email", user.getEmail());
			return "login/logIn";
		}
		else if(fetchedUser.getPassword().equals(user.getPassword())) {
			return "findFlights";
		}else {
			userDetails.addAttribute("passwordLoginError", "Incorrect Password");
			userDetails.addAttribute("email", user.getEmail());
		}
		
		return "login/logIn";
	}
}
