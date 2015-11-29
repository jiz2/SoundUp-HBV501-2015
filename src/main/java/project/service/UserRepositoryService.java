package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserRepositoryService {

    // Instance Variables
    UserRepository repository;

    // Dependency Injection
    @Autowired
    public UserRepositoryService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a {@link User}
     * @param user {@link User} to be saved
     * @return {@link User} that was saved
     */
    public User save(User user) {
        return repository.save(user);
    }

    /**
     * Delete {@link User}
     * @param user {@link User} to be deleted
     */
    public void delete(User user) {
        repository.delete(user);
    }

    /**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * Get all {@link User}s in a reverse order
     * @return A reversed list of {@link User}s
     */
    public List<User> findAllReverseOrder() {
        // Get all the users notes
        List<User> users = repository.findAll();

        // Reverse the list
        Collections.reverse(users);

        return users;
    }

    /**
     * Find a {@link User} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link User} with {@link Long id}
     */
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    /**
     * Find all {@link User}s with {@link String name}
     * @param name {@link String}
     * @return All {@link User}s with the {@link String name} passed
     */
    public User findByName(String name) {
        return repository.findByName(name).get(0);
    }
}
