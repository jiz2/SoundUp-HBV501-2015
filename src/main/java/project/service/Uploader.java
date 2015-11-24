package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.SoundClip;
import project.service.WebGenerator;

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
    * @param localPath local URI of the file to be uploaded
    * @return nothing
    */
    public void setPath(String localPath) throws Exception {
        // Check for file extensions

        this.name = localPath;

        // Throws Exception if file extension is not accepted
    }

    /**
    * Uploads the file with preentered name
    * @param model Model to pass result arguments
    * @return nothing
    */
    public void upload(Model model, MultipartFile file) throws Exception {

        // Here makes sure file is valid
        setPath(file.getOriginalFilename());

        // Store the file in the database
        String soundURI = dbCon.setSoundClip(new SoundClip(name, file.getBytes()));

        // Now let's add the attributes to the model
        model.addAttribute("soundURI",soundURI);
        model.addAttribute("url",webgen.makeUrl(name));
    }
}
