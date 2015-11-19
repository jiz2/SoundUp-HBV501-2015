package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.service.Pathfinder;
import project.service.StringManipulationService;
import project.service.Uploader;
import project.service.UrlGenerator;

@Controller
public class UploadController {

     // Instance Variables
     Pathfinder pathfinder;
     Uploader uploader;
     UrlGenerator urlGenerator;

     // Dependency Injection
     @Autowired
     public UploadController(Pathfinder pathfinder, Uploader uploader, UrlGenerator urlGenerator) {
         this.pathfinder = pathfinder;
         this.uploader = uploader;
         this.urlGenerator = urlGenerator;
         
     }

    // To call this method, enter "localhost:8080/upload" into a browser
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model){

        // Here we will show how to add attributes to a model and send it to the view

        // Get local filepath from user
    	String userFilepath = pathfinder.getPathFromUser();
    	
    	// Store file in database and get database filepath
    	String databaseFilepath = uploader.storeAndGetPath(userFilepath);
    	
    	// Generate new Url with database filepath
        String url = urlGenerator.generateUrl(databaseFilepath);

        // Now let's add the attributes to the model
        model.addAttribute("userFilepath",userFilepath);
        model.addAttribute("databaseFilepath",databaseFilepath);
        model.addAttribute("url",url);

        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        return "Result";
    }
}
