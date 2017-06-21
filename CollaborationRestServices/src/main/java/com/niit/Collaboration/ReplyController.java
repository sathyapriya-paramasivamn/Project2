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

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.DAO.CommentDAO;
import com.niit.Collaboration.DAO.ForumDAO;
import com.niit.Collaboration.DAO.ReplyDAO;
import com.niit.Collaboration.Model.Blog;

import com.niit.Collaboration.Model.Reply;
import com.niit.Collaboration.Model.User;



@RestController 

public class ReplyController {     
	@Autowired

	private ReplyDAO replyDAO;   
 
	@Autowired
	private BlogDAO blogDAO;  
 
	@GetMapping("/reply")     
	public ResponseEntity<List<Reply>> getReplys() {
		
		List<Reply> listreply = replyDAO.list();
		return new ResponseEntity<List<Reply>>(listreply, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/replys/{id}")  
	public ResponseEntity deleteComment(@PathVariable("id") int replyId) {

		replyDAO.delete(replyId);
		return new ResponseEntity(replyId, HttpStatus.OK);
	}
 
	@GetMapping("/replys/{id}")
	public ResponseEntity<Reply> getByReplyId(@PathVariable("id") int ReplyId) {

		Reply reply = replyDAO.getByreplyId(ReplyId);
		return new ResponseEntity<Reply>(reply, HttpStatus.OK); 
	}
   
	@PostMapping("/reply")
	public ResponseEntity save(@RequestBody Reply reply,HttpSession session) {
		  
		Blog blog = (Blog) session.getAttribute("blog");
		User user=(User) session.getAttribute("user");
		reply.setMailid(user.getMailid()); 
		reply.setId(blog.getId());
		reply.setTitle(blog.getTitle()); 
		replyDAO.save(reply);  
		return new ResponseEntity(reply, HttpStatus.OK);
	}   
   
	@PutMapping("/reply")      
	public ResponseEntity update(@RequestBody Reply reply) {
		
		replyDAO.update(reply);
		return new ResponseEntity(reply, HttpStatus.OK);
	}  
	
	@GetMapping("/reply/{id}")    
	public ResponseEntity getForumid(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("haiii");     
		
		Blog blogValue = blogDAO.getById(id);
		   
		HttpSession session = request.getSession();
		session.setAttribute("blog", blogValue);   
		
		System.out.println("---------------------------------------");
		Blog blog = (Blog) session.getAttribute("blog");
		System.out.println(blog.getId());
		
		List listreply = replyDAO.getReply(id);
		if (listreply == null) {
			return new ResponseEntity("No Comment found for ID " + id, HttpStatus.NOT_FOUND);
		}
 
		return new ResponseEntity(listreply, HttpStatus.OK); 
	}
	
	   
}        
  