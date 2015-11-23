package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import project.service.WebGenerator;

/**
 * Service class that has methods for Uploading
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class Uploader {

    private String path;
    WebGenerator webgen;
    
    // Dependency Injection
    @Autowired
    public Uploader(WebGenerator webgen) {
    this.webgen = webgen;
    }

    /**
    * Sets the local URI of the file for upload
    * @param localPath local URI of the file to be uploaded
    * @return nothing
    */
    public void setPath(String localPath){
    this.path = localPath;
    }

    /**
    * Uploads the file with preentered path
    * @param model Model to pass result arguments
    * @return nothing
    */
    public void upload(Model model){
        // Now let's add the attributes to the model
        model.addAttribute("localURI",path);
//        model.addAttribute("soundURI",soundURI);
//        model.addAttribute("url",url);
    }
}
