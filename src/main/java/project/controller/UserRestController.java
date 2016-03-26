package project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.UserService;

import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import project.persistence.entities.User;


@RestController
@RequestMapping("/rest/api/user")
public class UserRestController {

	private final UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
	   this.userService = userService;
	}
	
//	@RequestMapping(value = "/crud/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> findAllUsers() {
//        List<User> users = userService.findAll();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
	
	@RequestMapping(value = "/crud/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUser(@PathVariable("name") String name) {
        System.out.println("Fetching User with name " + name);
        User user = userService.findByName(name).get(0);
        if (user == null) {
            System.out.println("User with name " + name + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
//    @RequestMapping(value = "/crud/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating User " + user.getName());
//        if (userService.exists(user.getId())) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//
//        userService.save(user);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/crud/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//
//        User currentUser = userService.findOne(id);
//
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setName(user.getName());
//
//        userService.save(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/crud/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
//        System.out.println("Fetching & Deleting User with id " + id);
//
//        User user = userService.findOne(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        userService.delete(user);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
//
//    @RequestMapping(value = "/crud/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
//        userService.deleteAll();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
//
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public void postReg(HttpSession session, @RequestParam String name, @RequestParam String pw) throws Exception{
//		System.out.println("Registrering User");
//		session.setAttribute("user", this.userService.register(new User(name, pw)));
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public void postLogin(HttpSession session, @RequestParam String name, @RequestParam String pw) throws Exception{
//		System.out.println("Logging In User");
//		session.setAttribute("user", this.userService.login(new User(name, pw)));
//	}
//
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public void logout(HttpSession session){
//		System.out.println("Logging Out User");
//		session.removeAttribute("user");
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public List<User> findAllLike(@RequestParam("searchTerm") String searchTerm){
//		return this.userService.findAllLike(searchTerm);
//	}
}
