package com.niit.Collaboration;

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
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.CommentDAO;
import com.niit.Collaboration.DAO.ForumDAO;
//import com.niit.Collaboration.Model.Blog;   
import com.niit.Collaboration.Model.Comment;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.User;


@RestController

public class CommentController {
	@Autowired

	private CommentDAO commentDAO;
    
	@Autowired  
	private ForumDAO forumDAO;
	@GetMapping("/comment")     
	public ResponseEntity<List<Comment>> getComments() {
		
		List<Comment> listcomment = commentDAO.list();
		return new ResponseEntity<List<Comment>>(listcomment, HttpStatus.OK);
	}
 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/comments/{id}")   
	public ResponseEntity deleteComment(@PathVariable("id") int commentId) {

		commentDAO.delete(commentId);
		return new ResponseEntity(commentId, HttpStatus.OK);
	}
 
	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> geByID(@PathVariable("id") int id) {

		Comment comment = commentDAO.getByCommentId(id);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK); 
	}

   
	@PostMapping("/comment")
	public ResponseEntity save(@RequestBody Comment comment,HttpSession session) {
		  
		Forum forum = (Forum) session.getAttribute("forum");
		comment.setForumId(forum.getForumid()); 
		comment.setForumName(forum.getName()); 
		User user = (User) session.getAttribute("user");  
		comment.setCommentName(user.getName());
		comment.setMailid(user.getMailid());
		comment.setUserId(user.getId());
		
		commentDAO.save(comment);    
		
		return new ResponseEntity(comment, HttpStatus.OK);
	}     
     
	@PutMapping("/comment")      
	public ResponseEntity update(@RequestBody Comment comment) {
		
		commentDAO.update(comment);  
		return new ResponseEntity(comment, HttpStatus.OK);
	}  
	@GetMapping("/comment/{forumid}")    
	public ResponseEntity getForumid(@PathVariable("forumid") int forumid, HttpServletRequest request) {
		System.out.println("haiii");     
		
		Forum forumValue = forumDAO.getByForumid(forumid);
		
		HttpSession session = request.getSession();
		session.setAttribute("forum", forumValue); 
		
		System.out.println("---------------------------------------");
		Forum forum = (Forum) session.getAttribute("forum");
		System.out.println(forum.getForumid());
		
		List listcomment = commentDAO.getComment(forumid);
		if (listcomment == null) {
			return new ResponseEntity("No Comment found for ID " + forumid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(listcomment, HttpStatus.OK);
	}
}    
  