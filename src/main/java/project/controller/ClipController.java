package project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.SoundClip;
import project.service.DatabaseConnector;

public class ClipController {

    // Instance Variables
    DatabaseConnector dbCon;

    @RequestMapping(value = "/clip/{name}", method = RequestMethod.GET)
    public String clip(Model model, @PathVariable String name){

        // Testing clip display
        SoundClip sc = dbCon.getSoundClip(name);

        model.addAttribute("name", sc.getName());
        model.addAttribute("clip", sc.getData());

        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        return "Result";
    }
}
