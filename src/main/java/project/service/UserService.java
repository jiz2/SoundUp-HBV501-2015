package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.persistence.entities.User;

import java.io.IOException;

/**
 * Service class that has methods for Uploading
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class UserService {

    // Instance Variables
    DatabaseConnector dbCon;
    StandardPasswordEncoder passwordEncoder;

    // Dependency Injection
    @Autowired
    public UserService(DatabaseConnector dbCon) {
        this.dbCon = dbCon;
        this.passwordEncoder = new StandardPasswordEncoder();
    }

    /**
    * Registers the given user
    * @param user Is the username
    * @param pass Is the password
    * @return nothing
    */
    public void register(Model model, String user, String pass) throws Exception {

        // Secure the password pass by hashing
        String hash = passwordEncoder.encode(pass);

        model.addAttribute("user", "A new user \'" + user + "\' has been created!");

        // Store the user in the database
        dbCon.setUser(new User(user, hash));
    }

    /**
     * Logins with the given name
     * @param name Is the username
     * @param pass Is the password
     * @return nothing
     */
    public User login(String name, String pass) throws Exception {

        // Loads the user from the database
        User user = dbCon.getUser(name);

        if (passwordEncoder.matches(pass, user.getHash())) {
            return user;
        } else {
            throw new Exception("Invalid username or password.");
        }
    }
}
