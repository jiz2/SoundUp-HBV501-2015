package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.service.DatabaseConnector;
import project.service.Uploader;
import project.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	// Instance Variables
	UserService userService;

	// Dependency Injection
	@Autowired
	public UserController(UserService userService) {
	   this.userService = userService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getReg(){

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postReg(Model model, @RequestParam String user, @RequestParam String pass){

		try {
			userService.register(model, user, pass);
		} catch (Exception e) {
			model.addAttribute("err", "Registration failed.");
		}

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(){

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session,
							@RequestParam String user, @RequestParam String pass){

		try {
			session.setAttribute("user", userService.login(user, pass));
		} catch (Exception e) {
			model.addAttribute("err", "Login failed.");
		}

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){

		session.removeAttribute("user");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "redirect:/";
	}
}
