package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.UserService;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {

	UserService uService;

	@Autowired
	public UserRestController(UserService uService) {
	   this.uService = uService;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String getReg(Model model){
		model.addAttribute("action", "Register");
		return "User";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String postReg(Model model, @RequestParam String name, @RequestParam String pass){
		try {
			this.uService.register(model, name, pass);
		} catch (Exception e) {
			model.addAttribute("err", "Registration failed.");
		}
		model.addAttribute("action", "Register");
		return "User";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String getLogin(Model model){
		model.addAttribute("action", "Login");
		return "User";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session, @RequestParam String user, @RequestParam String pw){
		try {
			session.setAttribute("user", this.uService.login(user, pw));
		} catch (Exception e) {
			model.addAttribute("err", "Login failed.");
		}
		model.addAttribute("action", "Login");
		return "User";
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/";
	}
}
