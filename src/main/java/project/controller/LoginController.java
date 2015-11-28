package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;

//import project.service.Uploader;

@Controller
public class LoginController {
	// Instance Variables
	//Uploader uploader;

	// Dependency Injection
	//@Autowired
	//public LoginController(){//Uploader uploader) {
	   //this.uploader = uploader;
	//}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registration(Model model){

		// Pass dummy text for the get Page
		model.addAttribute("msg", "bla!");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model){

		// Pass dummy text for the get Page
		model.addAttribute("msg", "Hello world!");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Registration";
	}
	
	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String createUser(Model model){

		// Pass dummy text for the get Page
		model.addAttribute("msg", "Hello!");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Registration";
	}
}
