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
  
import com.niit.Collaboration.DAO.CommentDAO;
//import com.niit.Collaboration.Model.Blog;   
import com.niit.Collaboration.Model.Comment;


@RestController

public class CommentController {
	@Autowired

	private CommentDAO commentDAO;  
 
	@GetMapping("/comment")     
	public ResponseEntity<List<Comment>> getComments() {
		
		List<Comment> listcomment = commentDAO.list();
		return new ResponseEntity<List<Comment>>(listcomment, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/comments/{id}")  
	public ResponseEntity deleteComment(@PathVariable("id") int cid) {

		commentDAO.delete(cid);
		return new ResponseEntity(cid, HttpStatus.OK);
	}
 
	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> geByID(@PathVariable("id") int id) {

		Comment comment = commentDAO.getByCid(id);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

 
	@PostMapping("/comment")
	public ResponseEntity save(@RequestBody Comment comment) {
		  
		/*Blog blog = (Blog) session.getAttribute("blog");
		comment.setMailid(blog.getUsermailid());
		comment.setName(blog.getTitle());*/
		commentDAO.save(comment);    
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}  
 
	@PutMapping("/comment")      
	public ResponseEntity update(@RequestBody Comment comment) {
		
		commentDAO.update(comment);
		return new ResponseEntity(comment, HttpStatus.OK);
	}  
}  
  