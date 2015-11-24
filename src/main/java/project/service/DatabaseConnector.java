package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.repositories.SoundClipRepository;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class DatabaseConnector {

    // Instance Variables
    SoundClipService scService;

    // Dependency Injection
    @Autowired
    public DatabaseConnector(SoundClipService scService) {
        this.scService = scService;
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @return String
     */
    public String setSoundClip(SoundClip sc){
        // Here needs to add sc to our database (SoundClipRepository)
        String path = "yourPathHere";
    	return path;
    }
}
