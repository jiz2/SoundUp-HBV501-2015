package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.repositories.SoundClipRepository;

import java.util.Collections;
import java.util.List;

@Service
public class PostitNoteServiceImplementation implements PostitNoteService {

    // Instance Variables
    PostitNoteRepository repository;

    // Dependency Injection
    @Autowired
    public PostitNoteServiceImplementation(PostitNoteRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a {@link PostitNote}
     * @param postitNote {@link PostitNote} to be saved
     * @return {@link PostitNote} that was saved
     */
    public PostitNote save(PostitNote postitNote) {
        return repository.save(postitNote);
    }

    /**
     * Delete {@link PostitNote}
     * @param postitNote {@link PostitNote} to be deleted
     */
    public void delete(PostitNote postitNote) {
        repository.delete(postitNote);
    }

    /**
     * Get all {@link PostitNote}s
     * @return A list of {@link PostitNote}s
     */
    public List<PostitNote> findAll() {
        return repository.findAll();
    }

    /**
     * Get all {@link PostitNote}s in a reverse order
     * @return A reversed list of {@link PostitNote}s
     */
    public List<PostitNote> findAllReverseOrder() {
        // Get all the Postit notes
        List<PostitNote> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
    }

    /**
     * Find a {@link PostitNote} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link PostitNote} with {@link Long id}
     */
    public PostitNote findOne(Long id) {
        return repository.findOne(id);
    }

    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    public List<PostitNote> findByName(String name) {
        return repository.findByName(name);
    }
}
