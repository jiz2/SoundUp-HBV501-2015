package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import project.persistence.entities.SoundClip;
import project.persistence.entities.UserSoundClip;
import project.service.DatabaseConnector;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Controller
public class ClipController {

    // Instance Variables
    DatabaseConnector dbCon;

    // Dependency Injection
    @Autowired
    public ClipController(DatabaseConnector dbCon) {
        this.dbCon = dbCon;
    }

    @RequestMapping(value = "/clip/{name}.{ext}", method = RequestMethod.GET)
    public String clip(Model model, @PathVariable String name, @PathVariable String ext){

        boolean userFile = false;
        try {
            // Testing clip display
            SoundClip sc = dbCon.getSoundClip(name+ "." + ext);

            model.addAttribute("name", sc.getName());
            model.addAttribute("ext", sc.getExt());
            model.addAttribute("data", Base64.getEncoder().encodeToString(sc.getData()));
        } catch (Exception e) {
            userFile = true;
        }
        if (userFile) {
            try {
                // Testing user clip display
                UserSoundClip sc = dbCon.getUserSoundClip(name + "." + ext);

                model.addAttribute("user", sc.getUser());
                model.addAttribute("name", sc.getName());
                model.addAttribute("ext", sc.getExt());
                model.addAttribute("data", Base64.getEncoder().encodeToString(sc.getData()));
            } catch (Exception e) {
                model.addAttribute("err", "File not Found.");
            }
        }

        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        return "Result";
    }
}
