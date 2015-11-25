package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.SoundClip;
import project.service.WebGenerator;

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
    * Sets the local URI of the file for upload
    * @param file local URI of the file to be uploaded
    * @return nothing
    */
    public void setPath(MultipartFile file) throws Exception {

        // Check for file extensions
        String type = file.getContentType().split("/")[0];

        // Throws Exception if file extension is not accepted
        if (type.equalsIgnoreCase("audio")) {
            this.name = file.getOriginalFilename();
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
    public void upload(Model model, MultipartFile file) throws Exception {

        // Store the file in the database
        try {
            dbCon.setSoundClip(new SoundClip(name, file.getBytes()));
        } catch (IOException ioe) {
            throw new Exception("Failed to upload the file. Please try again.");
        }

        // Now let's add the attributes to the model
        model.addAttribute("type", file.getContentType());
        model.addAttribute("url", webgen.makeUrl(name));

        // Reset name
        name = new String();
    }
}
