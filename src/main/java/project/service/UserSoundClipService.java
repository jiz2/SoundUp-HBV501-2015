package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.UserSoundClip;
import project.persistence.repositories.UserSoundClipRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserSoundClipService {

    // Instance Variables
    UserSoundClipRepository repository;

    // Dependency Injection
    @Autowired
    public UserSoundClipService(UserSoundClipRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a {@link UserSoundClip}
     * @param userSoundClip {@link UserSoundClip} to be saved
     * @return {@link UserSoundClip} that was saved
     */
    public UserSoundClip store(UserSoundClip userSoundClip) {
        return repository.save(userSoundClip);
    }

    /**
     * Delete {@link UserSoundClip}
     * @param userSoundClip {@link UserSoundClip} to be deleted
     */
    public void delete(UserSoundClip userSoundClip) {
        repository.delete(userSoundClip);
    }

    /**
     * Get all {@link UserSoundClip}s
     * @return A list of {@link UserSoundClip}s
     */
    public List<UserSoundClip> findAll() {
        return repository.findAll();
    }

    /**
     * Get all {@link UserSoundClip}s in a reverse order
     * @return A reversed list of {@link UserSoundClip}s
     */
    public List<UserSoundClip> findAllReverseOrder() {
        // Get all the UserSoundClips notes
        List<UserSoundClip> soundClips = repository.findAll();

        // Reverse the list
        Collections.reverse(soundClips);

        return soundClips;
    }

    /**
     * Find a {@link UserSoundClip} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link UserSoundClip} with {@link Long id}
     */
    public UserSoundClip findOne(Long id) {
        return repository.findOne(id);
    }

    /**
     * Find all {@link UserSoundClip}s with {@link String name}
     * @param name {@link String}
     * @return All {@link UserSoundClip}s with the {@link String name} passed
     */
    public UserSoundClip findByName(String name) {
        return repository.findByName(name).get(0);
    }
}
