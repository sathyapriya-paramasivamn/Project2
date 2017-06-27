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

import com.niit.Collaboration.DAO.ForumDAO;

import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.User;

 
@RestController
public class ForumController {
	@Autowired
	private ForumDAO forumDAO;

	 

	@GetMapping("/forum")
	public ResponseEntity<List<Forum>> getForums() {
		List<Forum> listforum = forumDAO.list();
		return new ResponseEntity<List<Forum>>(listforum, HttpStatus.OK);
	}
	@GetMapping("/acceptedforum") 
	public ResponseEntity<List<Forum>> getacceptedForumsList() {
		List<Forum> listforum = forumDAO.acceptedList();
		return new ResponseEntity<List<Forum>>(listforum, HttpStatus.OK);
	}
	@GetMapping("/notAcceptedforum") 
	public ResponseEntity<List<Forum>> getnotAcceptedForumList() {
		List<Forum> listforum = forumDAO.notAcceptedList();
		return new ResponseEntity<List<Forum>>(listforum, HttpStatus.OK);
	}
  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/forums/{id}")
	public ResponseEntity deleteForum(@PathVariable("id") int forumid) {

		forumDAO.delete(forumid);
		return new ResponseEntity(forumid, HttpStatus.OK);
	}
	@GetMapping("/forums/{id}")
	public ResponseEntity<Forum> getForumByID(@PathVariable( "id") int id) {
  
		Forum forum = forumDAO.getByForumid(id);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
	@PostMapping("/forum")
	public ResponseEntity save(@RequestBody Forum forum, HttpSession session)
	{
		User user = (User) session.getAttribute("user");  
		System.out.println(user.getMailid());
		System.out.println(user.getMobileno());
		forum.setUsermailid(user.getMailid()); 
		forum.setUsername(user.getName()); 
		forum.setStatus("NA");     
		forumDAO.save(forum);    
		return new ResponseEntity(forum, HttpStatus.OK); 
	} 
	@PutMapping("/acceptForum")
	public ResponseEntity acceptForum(@RequestBody Forum forum){
		forum.setStatus("A");
		forumDAO.update(forum);
		return new ResponseEntity("No forum found for id " + forum.getForumid(), HttpStatus.NOT_FOUND);
	}
	@PutMapping("/forum") 
	public ResponseEntity update(@RequestBody Forum forum)
	{
		forumDAO.update(forum); 
		return new ResponseEntity(forum, HttpStatus.OK); 
	}
       
}
   