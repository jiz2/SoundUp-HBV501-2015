package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.PostitNote;
import project.persistence.repositories.PostitNoteRepository;
import project.service.PostitNoteService;

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

    @Override
    public PostitNote save(PostitNote postitNote) {
        return repository.save(postitNote);
    }

    @Override
    public void delete(PostitNote postitNote) {
        repository.delete(postitNote);
    }

    @Override
    public List<PostitNote> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PostitNote> findAllReverseOrder() {
        // Get all the Postit notes
        List<PostitNote> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
    }

    @Override
    public PostitNote findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<PostitNote> findByName(String name) {
        return repository.findByName(name);
    }
}
