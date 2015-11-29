package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.SoundClip;
import project.persistence.entities.User;
import project.persistence.entities.UserSoundClip;
import project.service.WebGenerator;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Service class that has methods for Uploading
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class Uploader {

    // Instance Variables
    private String name;
    WebGenerator webgen;
    DatabaseConnector dbCon;
    
    // Dependency Injection
    @Autowired
    public Uploader(WebGenerator webgen, DatabaseConnector dbCon) {
        this.webgen = webgen;
        this.dbCon = dbCon;
    }

    /**
    * Sets the name of the file for upload
    * @param type type of the file
    * @param name name of the file
    * @return nothing
    */
    public void setPath(String type, String name) throws Exception {

        // Throws Exception if file type is not accepted
        if (type.equalsIgnoreCase("audio")) {
            this.name = name.replaceAll(" ", "_");
        } else {
            throw new Exception("This file type is not accepted.");
        }
    }

    /**
    * Uploads the file with preentered name
    * @param model Model to pass result arguments
    * @param file Is the uploaded file
    * @return nothing
    */
    public void upload(Model model, HttpSession session, MultipartFile file) throws Exception {

        // Make sure the file is valid
        String[] type = file.getContentType().split("/");
        setPath(type[0], file.getOriginalFilename());

        // Store the file in the database
        try {
            User user = (User) session.getAttribute("user");
            System.out.println(user);
            System.out.println(user.getName());
            if (user != null) {
                dbCon.setSoundClip(new UserSoundClip(user.getName(), name, type[1], file.getBytes()));
            } else {
                dbCon.setSoundClip(new SoundClip(name, type[1], file.getBytes()));
            }
        } catch (IOException ioe) {
            throw new Exception("Failed to upload the file. Please try again.");
        }

        // Now let's add the attributes to the model
        model.addAttribute("url", webgen.makeUrl(name));

        // Reset name
        name = new String();
    }
}
