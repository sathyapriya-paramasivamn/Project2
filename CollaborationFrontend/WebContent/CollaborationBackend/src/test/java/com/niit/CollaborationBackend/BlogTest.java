package com.niit.CollaborationBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.DAO.CommentDAO;

import com.niit.Collaboration.DAO.EventDAO;
import com.niit.Collaboration.DAO.ForumDAO;
import com.niit.Collaboration.DAO.FriendDAO;
import com.niit.Collaboration.DAO.JobDAO;
import com.niit.Collaboration.DAO.ReplyDAO;
import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Comment;
import com.niit.Collaboration.Model.Event;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.Friend;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Model.Reply;
import com.niit.Collaboration.Model.User;
 
public class BlogTest {  
	public static void main (String[] args) {

	    
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 context.scan("com.niit.*");  
		context.refresh();    
		      
		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");  
		Blog blog = (Blog) context.getBean("blog");
	
		UserDAO userDAO=(UserDAO) context.getBean("UserDAO"); 
		User user=(User)context.getBean("user");
		 
		EventDAO eventDAO=(EventDAO) context.getBean("EventDAO");
		Event event=(Event)context.getBean("event"); 
		
		ForumDAO forumDAO=(ForumDAO) context.getBean("ForumDAO");
		Forum forum=(Forum)context.getBean("forum");
		
		FriendDAO friendDAO=(FriendDAO) context.getBean("FriendDAO");
		Friend friend=(Friend)context.getBean("friend");
		
		JobDAO jobDAO=(JobDAO) context.getBean("JobDAO");
		Job job=(Job)context.getBean("job");
		
		ReplyDAO replyDAO=(ReplyDAO) context.getBean("replyDAO");
		Reply reply=(Reply)context.getBean("reply"); 
		
		CommentDAO commentDAO=(CommentDAO) context.getBean("commentDAO");
		Comment comment=(Comment)context.getBean("comment");   
		
		  
	blog.setUsermailid("abi@gmail.com");
	blog.setUsername("abi");   
	blog.setTitle("placement session");
	blog.setDescription("www.indiabixapp.com,www.mathcrack.com");
   
    blogDAO.save(blog);  
     
         
  user.setName("abi");         
  user.setMailid("abi@gmail.com");
  user.setMobileno("9878787898");
  user.setPassword("sa23");
  user.setRole("student");
  user.setResidential("coimbatore");  
  user.setPincode("642222");        
  //user.setOnline(0);   
		userDAO.save(user); 
	     
    event.setEventname("IEEE Conference");  
    event.setEventcategory("Conference");
    event.setEventdatails("The 7th International Conference & Workshop" );
  	eventDAO.save(event);
        
  	forum.setName("Discussion board");
  	forum.setMessage("school system will change"); 
  	forumDAO.save(forum);
  	forum.setStatus("na");
   
  	
    friend.setFriendid(2);
    friend.setUserid(382);
  	friend.setFriendname("jvbjdf");
  	friend.setStatus("friend");
  	friend.setUsername("sai");  
  	
  	friend.setStatus("friend");    
   	friendDAO.save(friend);  

   	job.setJobcategory("software engineer");
   	job.setJobdetails("company ntt data, qualification BE, Address coimbatore"); 
   	job.setJobname("software developer");
   	jobDAO.save(job);
   	 
   	comment.setCommentName("sai");
   	comment.setMailid("sai@sathya.com");  
   	comment.setForumName("hi");
   	comment.setContent("worried");
   	comment.setForumId(123);  
   	comment.setUserId(2);
    commentDAO.save(comment);     

	reply.setMailid("sai@gmail.com");
	reply.setReplyId(2);
	reply.setReplymsg("jkj");
	reply.setTitle("discution");
	replyDAO.save(reply); 
	
	}        
	  
} 
