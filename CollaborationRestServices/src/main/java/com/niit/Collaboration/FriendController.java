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
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.FriendDAO;  

import com.niit.Collaboration.Model.Friend;
import com.niit.Collaboration.Model.User;
 
@RestController 
public class FriendController {
	@Autowired(required = true)
	private FriendDAO friendDAO;
	      
	@Autowired   
	private Friend friend;  
    
	public FriendDAO getFriendDAO() { 
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
	 
	@GetMapping("/friends")
	public List<Friend> getCustomers() { 
		return friendDAO.list();
	}
	
	@GetMapping("/friend/{userid}")
	public List<Friend> getByUser(@PathVariable("userid") int userid) {
		return friendDAO.list(userid);
	}
	
	@GetMapping("/friends/{name}")  
	public List<Friend> geByID(@PathVariable("name") String name) {
		return friendDAO.getByFriendName(name);
		   
	}
	
	@GetMapping("/friendsAccepted/{name}")  
	public List<Friend> geByFriendAccepted(@PathVariable("name") String name) {
		return friendDAO.getByFriendAccepted(name);
		
	}
	
	@PostMapping("/friends")
	public ResponseEntity createFriend(@RequestBody User friendUser, HttpSession session) {
		User user = (User) session.getAttribute("user");   
		friend.setUserid(user.getId());
		friend.setUsername(user.getName());
		friend.setStatus("P");
		friend.setFriendid(friendUser.getId());
		friend.setFriendname(friendUser.getName());
		//friend.setIsOnline("TRUE");
	
		friendDAO.save(friend);

		return new ResponseEntity(friend, HttpStatus.OK);
	}
	
	@PutMapping("/friendAccept")
	public ResponseEntity acceptFriend(@RequestBody Friend friend){
		
		friend.setStatus("A");
		friend = friendDAO.saveOrUpdate(friend); 
		
		return new ResponseEntity(friend, HttpStatus.OK);
	}
	 
	@DeleteMapping("/friends/{id}")  
	public ResponseEntity deleteFriend(@PathVariable int id) {
		Friend friend=friendDAO.getByFriendid(id); 
 		if (friend==null) {
			return new ResponseEntity("No friend found for ID " + id, HttpStatus.NOT_FOUND);
		}
 		friendDAO.delete(id);     
		return new ResponseEntity(id, HttpStatus.OK);  
     
	}
}