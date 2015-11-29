package project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.entities.User;
import project.persistence.entities.UserSoundClip;

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
    UserSoundClipService uscService;
    UserRepositoryService urService;

    // Dependency Injection
    @Autowired
    public DatabaseConnector(SoundClipService scService,
                             UserSoundClipService uscService, UserRepositoryService urService) {
        this.scService = scService;
        this.uscService = uscService;
        this.urService = urService;
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param sc is the sound clip to be stored
     * @return String
     */
    public void setSoundClip(SoundClip sc) throws Exception {
        try {
            // Here needs to add sc to our database (SoundClipRepository)
            scService.store(sc);
        } catch (ConstraintViolationException ce) {
            throw new Exception("A file already exists with the same name!");
        }
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param usc is the sound clip to be stored
     * @return String
     */
    public void setSoundClip(UserSoundClip usc) throws Exception {
        try {
            // Here needs to add sc to our database (SoundClipRepository)
            uscService.store(usc);
        } catch (ConstraintViolationException ce) {
            throw new Exception("A file already exists with the same name!");
        }
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param name is name of the sound clip to be retrieved
     * @return the Sound clip
     */
    public SoundClip getSoundClip(String name, String ext) {
        return scService.findByNameAndExt(name, ext);
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param name is name of the sound clip to be retrieved
     * @return the Sound clip
     */
    public UserSoundClip getUserSoundClip(String name) {
        return uscService.findByName(name);
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @return String
     */
    public void setUser(User user) throws Exception {
        try {
            // Here needs to add sc to our database (UserRepository)
            urService.save(user);
        } catch (ConstraintViolationException ce) {
            System.out.println(ce.getMessage());
            throw new Exception("A user already exists with the same name!");
        }
    }

    /**
     * Returns the user with the given name
     * @return String
     */
    public User getUser(String name) {
        return urService.findByName(name);
	}
	
    public List<SoundClip> searchSoundClips(String search) {
        return scService.findAllLike(search);
    }
}
