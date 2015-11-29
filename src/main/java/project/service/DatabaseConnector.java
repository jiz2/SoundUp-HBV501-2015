package project.service;

import java.util.List;
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
    public void setSoundClip(SoundClip sc) throws Exception {
        try {
            // Here needs to add sc to our database (SoundClipRepository)
            scService.store(sc);
        } catch (org.hibernate.exception.ConstraintViolationException ce) {
            throw new Exception("A file already exists with the same name!");
        }
    }

    public SoundClip getSoundClip(String name) {
        return scService.findByName(name);
    }

    public String searchSoundClips(String search) {
        return scService.findAllLike(search);
    }
}
