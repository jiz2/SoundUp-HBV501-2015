package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.StringManipulationService;

@Controller
public class UploadController {

    // // Instance Variables
    // StringManipulationService stringService;

    // // Dependency Injection
    // @Autowired
    // public UploadController(StringManipulationService stringService) {
    //     this.stringService = stringService;
    // }

    // To call this method, enter "localhost:8080/upload" into a browser
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model){

        // Here we will show how to add attributes to a model and send it to the view

        // Faked generated Url
        String res = "This is a fake Url";

        // Now let's add the attributes to the model
        model.addAttribute("res",res);

        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        return "Result";
    }
}
