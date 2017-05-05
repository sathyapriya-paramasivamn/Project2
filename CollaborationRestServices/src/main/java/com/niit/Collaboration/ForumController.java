package com.niit.Collaboration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.ForumDAO;
import com.niit.Collaboration.Model.Forum;


@RestController
public class ForumController {
	@Autowired
	private ForumDAO forumDAO;

	

	@GetMapping("/forum")
	public ResponseEntity<List<Forum>> getForums() {
		List<Forum> listforum = forumDAO.list();
		return new ResponseEntity<List<Forum>>(listforum, HttpStatus.OK);
	}
  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/forums/{id}")
	public ResponseEntity deleteForum(@PathVariable("id") int forumid) {

		forumDAO.delete(forumid);
		return new ResponseEntity(forumid, HttpStatus.OK);
	}
	@GetMapping("/forums/{id}")
	public ResponseEntity<Forum> getForumByID(@PathVariable("id") int id) {

		Forum forum = forumDAO.getByForumid(id);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
}
