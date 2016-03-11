package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.UserService;

import javax.servlet.http.HttpSession;
import project.persistence.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
	   this.userService = userService;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(Model model){
		model.addAttribute("action", "Register");
		return "User";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(Model model, HttpSession session, @RequestParam String name, @RequestParam String pw){
		try {
			User u = this.userService.register(new User(name, pw));
			model.addAttribute("user", u);
			session.setAttribute("user", u);
		} catch (Exception e) {	
			model.addAttribute("err", "Registration failed: " + e.getMessage());
		}
		model.addAttribute("action", "Register");
		return "User";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model){
		model.addAttribute("action", "Login");
		return "User";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session, @RequestParam String name, @RequestParam String pw){
		try {
			User u = this.userService.login(new User(name, pw));
			model.addAttribute("user", u);
			session.setAttribute("user", u);
		} catch (Exception e) {
			model.addAttribute("err", "Login failed: " + e.getMessage());
		}
		model.addAttribute("action", "Login");
		return "User";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/";
	}
}
