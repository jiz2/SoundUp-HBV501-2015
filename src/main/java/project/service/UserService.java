package project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import project.persistence.repositories.UserRepository;

@Service("userService")
@Transactional
public class UserService {
	
	UserRepository uRepo;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public long count(){
		return this.uRepo.count();
	}
	public void delete(User u){
		this.uRepo.delete(u);
	}
	public void deleteAll(){
		this.uRepo.deleteAll();
	}
	public Boolean exists(Long id){
		return this.uRepo.exists(id);
	}
	public List<User> findAll(){
		return this.uRepo.findAll();
	}
	public User findOne(long id){
		return this.uRepo.findOne(id);
	}
	public User save(User u){
		String encodedPw = passwordEncoder.encode(u.getPw());
		u.setPw(encodedPw);
		return this.uRepo.save(u);
	}
	
	public List<User> findByName(String s){
		return this.uRepo.findByName(s);
	}
	
	public List<User> findAllLike(String s) {
		return this.uRepo.findAllLike(s.toUpperCase());
	}
	
    public User register(User u) throws Exception {
		String name = u.getName();
		List<User> lu = this.uRepo.findByName(name);
		if(!lu.isEmpty()){
			throw new Exception("A user already exists with the same name!");
		}
		
		String encodedPw = passwordEncoder.encode(u.getPw());
		u.setPw(encodedPw);
		try {
			return this.uRepo.save(u);
		} catch (ConstraintViolationException ce) {
            throw ce;
        }
    }

    public User login(User u) throws Exception {
		String name = u.getName();
		List<User> lu = this.uRepo.findByName(name);
		if(lu.isEmpty()){
			throw new Exception("We could not find a user with the name \""+name+"\".");
		}
			
		User u_data = lu.get(0);
		if (passwordEncoder.matches(u.getPw(), u_data.getPw())) {
            return u_data;
        } else {
            throw new Exception("Invalid username or password.");
        }
    }
}