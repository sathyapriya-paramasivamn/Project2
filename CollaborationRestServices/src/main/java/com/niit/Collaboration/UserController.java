package com.niit.Collaboration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.FriendDAO;
import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.Model.Friend;
import com.niit.Collaboration.Model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;
 
	@Autowired
	private FriendDAO friendDAO;  

	@GetMapping("/users")
	public List<User> getUsers(HttpSession session) {
		
		List<User> userList = userDAO.list();
		
		return userList;

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable int id) {
		User user = userDAO.getById(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		userDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	// http://localhost:8080/CollaborationResetService/user/niit
	@GetMapping("/userid/{id}")
	public ResponseEntity getUserByID(@PathVariable("id") int id) {

		User user = userDAO.getById(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@GetMapping("/username/{name}")
	public ResponseEntity<User> getUserByID(@PathVariable("name") String name) {

		User user = userDAO.getByName(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/usermail/{email}")
	public ResponseEntity<User> getByMailid(@PathVariable("mailid") String email) {

		User user = userDAO.getByMailid(email);
	
 
		if (user == null) {
			return new ResponseEntity("No User found for email " + email, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	} 

	@PostMapping("/user")
	public ResponseEntity save(@RequestBody User user) {
		userDAO.save(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity update(@RequestBody User user) {
		userDAO.saveOrUpdate(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User validUser = userDAO.login(user);
		if (validUser == null) {
			Error error = new Error("Invalid credentials.. please enter valid username and password");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} else {
			session.setAttribute("user", validUser);

			System.out.println(validUser.getMailid());
			System.out.println(validUser.getName());
			User user1 = (User) session.getAttribute("user");
			System.out.println(user1.getRole());
			System.out.println(user1.getMobileno());
			return new ResponseEntity<User>(validUser, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			Error error = new Error("Unauthorized user.. Please Login..");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} else {
			// user.setOnline(false);  
			userDAO.saveOrUpdate(user);
			session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
	}
}    