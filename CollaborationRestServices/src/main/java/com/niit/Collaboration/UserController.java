package com.niit.Collaboration;

import java.util.List;

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

import com.niit.Collaboration.DAO.UserDAO;

import com.niit.Collaboration.Model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> listuser = userDAO.list();
		return new ResponseEntity<List<User>>(listuser, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") int userid) {
		User user = userDAO.getByUserid(userid);
		if (user == null) {
			return new ResponseEntity("No User found for getByUserid " + userid, HttpStatus.NOT_FOUND);
		}
		userDAO.delete(userid);
		return new ResponseEntity(userid, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable("id") int id) {

		User user = userDAO.getByUserid(id);  
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("/users/mail/{id}")
	public ResponseEntity<User> getByMailid(@PathVariable("id") String id) {
		
		User user = userDAO.getByMailid(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
 	}
	
	

	@PostMapping("/user")
	public ResponseEntity save(@RequestBody User user)
	{
		//user.setOnline(false);
		userDAO.save(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}
	@PutMapping("/user")  
	public ResponseEntity update(@RequestBody User user)
	{
		userDAO.update(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}	
	  
@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session) {
		User validUser = userDAO.login(user);
		if (validUser == null) {
			Error error = new Error("Invalid credentials.. please enter valid username and password");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} 
		else { 
			session.setAttribute("user", validUser);
			  
			
			System.out.println(validUser.getMailid());
			System.out.println(validUser.getName());
			return new ResponseEntity<User>(validUser, HttpStatus.OK);
		}
	}
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
			Error error =new Error("Unauthorized user.. Please Login..");  
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{
			//user.setOnline(false);
			userDAO.update(user);
			session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}  