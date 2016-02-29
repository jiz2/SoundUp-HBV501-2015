package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.persistence.entities.User;

import org.hibernate.exception.ConstraintViolationException;
import project.persistence.repositories.UserRepository;

@Service
public class UserService {

    UserRepository uRepo;
    StandardPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
        this.passwordEncoder = new StandardPasswordEncoder();
    }
	
    public void register(Model model, String user, String pass) throws Exception {
        // Secure the password pass by hashing
        String hash = passwordEncoder.encode(pass);

        // Store the user in the database
		try {
			this.uRepo.save(new User(user, hash));
		} catch (ConstraintViolationException ce) {
            System.out.println(ce.getMessage());
            throw new Exception("A user already exists with the same name!");
        }
		
		model.addAttribute("user", user);
    }

    public User login(String name, String pass) throws Exception {
        // Loads the user from the database
        User user = this.uRepo.findByName(name).get(0);

        if (passwordEncoder.matches(pass, user.getPw())) {
            return user;
        } else {
            throw new Exception("Invalid username or password.");
        }
    }
}
