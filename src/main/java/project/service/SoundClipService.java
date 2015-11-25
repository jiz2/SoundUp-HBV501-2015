package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.repositories.SoundClipRepository;

import java.util.Collections;
import java.util.List;

@Service
public class SoundClipService {

    // Instance Variables
    SoundClipRepository repository;

    // Dependency Injection
    @Autowired
    public SoundClipService(SoundClipRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a {@link SoundClip}
     * @param soundClip {@link SoundClip} to be saved
     * @return {@link SoundClip} that was saved
     */
    public SoundClip store(SoundClip soundClip) {
        return repository.save(soundClip);
    }

    /**
     * Delete {@link SoundClip}
     * @param soundClip {@link SoundClip} to be deleted
     */
    public void delete(SoundClip soundClip) {
        repository.delete(soundClip);
    }

    /**
     * Get all {@link SoundClip}s
     * @return A list of {@link SoundClip}s
     */
    public List<SoundClip> findAll() {
        return repository.findAll();
    }

    /**
     * Get all {@link SoundClip}s in a reverse order
     * @return A reversed list of {@link SoundClip}s
     */
    public List<SoundClip> findAllReverseOrder() {
        // Get all the Postit notes
        List<SoundClip> soundClips = repository.findAll();

        // Reverse the list
        Collections.reverse(soundClips);

        return soundClips;
    }

    /**
     * Find a {@link SoundClip} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link SoundClip} with {@link Long id}
     */
    public SoundClip findOne(Long id) {
        return repository.findOne(id);
    }

    /**
     * Find all {@link SoundClip}s with {@link String name}
     * @param name {@link String}
     * @return All {@link SoundClip}s with the {@link String name} passed
     */
    public SoundClip findByName(String name) {
        return repository.findByName(name).get(0);
    }
}
