package com.niit.Collaboration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.FriendDAO;

import com.niit.Collaboration.Model.Friend;

@RestController
public class FriendController {
	@Autowired
	private FriendDAO friendDAO;
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
	
	
	@GetMapping("/friend")
	public ResponseEntity<List<Friend>> getFriends() {
		List<Friend> listfriend = friendDAO.list();
		return new ResponseEntity<List<Friend>>(listfriend, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/friends/{id}")
	public ResponseEntity deleteFriend(@PathVariable("id") int friendid) {
		  
		friendDAO.delete(friendid);
		return new ResponseEntity(friendid, HttpStatus.OK);
	}

	@GetMapping("/friends/{id}")  
	public ResponseEntity<Friend> geByID(@PathVariable("id") int id) {

		Friend friend = friendDAO.getByFid(id);  
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	
}
