package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.service.Uploader;

import javax.servlet.http.HttpSession;

@Controller
public class UploadController {

	// Instance Variables
	Uploader uploader;

	// Dependency Injection
	@Autowired
	public UploadController(Uploader uploader) {
	   this.uploader = uploader;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String result(Model model){

		// Pass dummy text for the get Page
		model.addAttribute("url", "Here_be_dummy_URL");

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Result";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("file") MultipartFile file, HttpSession session){
		if (!file.isEmpty()) {
			try {
				// Let Uploader upload selected file
				uploader.upload(model, session, file);
			} catch (Exception e) {
				model.addAttribute("err", e.getMessage());
			}
		} else {
			model.addAttribute("err", "Please select a file for upload!");
		}

		// By adding attributes to the model, we can pass information from the controller
		// to the view (the .jsp file).
		return "Result";
	}
}
