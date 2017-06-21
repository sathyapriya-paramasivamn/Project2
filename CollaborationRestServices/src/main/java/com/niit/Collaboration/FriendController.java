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
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private Friend friend;
	 
	
	
	@GetMapping("/friend")
	public ResponseEntity<List<Friend>> getFriends() {
		List<Friend> listfriend = friendDAO.list();
		return new ResponseEntity<List<Friend>>(listfriend, HttpStatus.OK);
	}     
	@GetMapping("/acceptedfriend")  
	public ResponseEntity<List<Friend>> getacceptedFriendsList() {
		List<Friend> listfriend = friendDAO.acceptedList();
		return new ResponseEntity<List<Friend>>(listfriend, HttpStatus.OK);
	}
	@GetMapping("/notAcceptedfriend") 
	public ResponseEntity<List<Friend>> getnotAcceptedFriendList() {
		List<Friend> listfriend = friendDAO.notAcceptedList();
		return new ResponseEntity<List<Friend>>(listfriend, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })  
	@DeleteMapping("/friends/{id}")  
	public ResponseEntity deleteFriend(@PathVariable("id") int fid) {
		  
		friendDAO.delete(fid);  
		return new ResponseEntity(fid, HttpStatus.OK);
	}

	@GetMapping("/friends/{id}")    
	public ResponseEntity<Friend> getFriendByID(@PathVariable( "id") int id) {
  
		Friend friend = friendDAO.getByFriendid(id);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}
	@PostMapping("friend")  
	public ResponseEntity createFriend(@RequestBody  User friendUser, HttpSession session)
	{
		User user = (User) session.getAttribute("user"); 
		
		friend.setUserid(user.getId());
		friend.setUsername(user.getName()); 
		friend.setStatus("P");  
		friend.setFriendid(friendUser.getId());
	    friend.setFriendname(friendUser.getName());
		friendDAO.save(friend);
		return new ResponseEntity(friend, HttpStatus.OK);
	}  
	
	@PutMapping("/acceptFriend") 
	public ResponseEntity acceptFriend(@RequestBody Friend friend){
		friend.setStatus("A"); 
		friendDAO.update(friend);   
		return new ResponseEntity("No Blog found for id " + friend.getFriendid(), HttpStatus.NOT_FOUND);
	}  
	 
	@PutMapping("/friend")  
	public ResponseEntity update(@RequestBody Friend friend)
	{  
		friendDAO.update(friend);    
		return new ResponseEntity(friend, HttpStatus.OK);
	}	 
	
  
 
}
