package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.service.Uploader;

@Controller
public class UploadController {

	// Instance Variables
	Uploader uploader;

	// Dependency Injection
	@Autowired
	public UploadController(Uploader uploader) {
	   this.uploader = uploader;
	}

	// To call this method, enter "localhost:8080/upload" into a browser
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String result(Model model){

		// Pass dummy text for the get Page
		model.addAttribute("localURI", "Some random local URI for the file");
		model.addAttribute("soundURI", "Here be the URL of the file on the server.");
		model.addAttribute("url", "Here's the link to the page that " +
				"displays the URI once the system is complete");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Result";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(Model model){

		// Let Uploader upload selected file

		uploader.upload(model);

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Result";
	}
}
