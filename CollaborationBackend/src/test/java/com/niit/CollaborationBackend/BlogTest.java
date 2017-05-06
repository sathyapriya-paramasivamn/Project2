package com.niit.CollaborationBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.DAO.EventDAO;
import com.niit.Collaboration.DAO.ForumDAO;
import com.niit.Collaboration.DAO.FriendDAO;
import com.niit.Collaboration.DAO.JobDAO;
import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Event;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.Friend;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Model.User;
 
public class BlogTest {  
	public static void main (String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");  
		context.refresh();
		
		BlogDAO blogDAO = (BlogDAO) context.getBean("BlogDAO");
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
	
	blog.setTitle("placement session");
	blog.setDescription("www.indiabixapp.com,www.mathcrack.com");
    blog.setStatus("active");
    blogDAO.save(blog);
    
    
  user.setName("abi");  
  user.setMailid("abi@gmail.com");
  user.setMobileno("9878787898");
  user.setPassword("sa23");
  user.setRole("student");
  user.setResidential("coimbatore");
  user.setPincode("642222");
  userDAO.save(user);

	   
    event.setEventname("IEEE Conference");
    event.setEventcategory("Conference");
    event.setEventdatails("The 7th International Conference & Workshop" );
  	eventDAO.save(event);
      
  	forum.setName("Discussion board");
  	forum.setMessage("school system will change");
  	forumDAO.save(forum);
    
  	
  	friend.setStatus("friend");
   	friendDAO.save(friend);

   	job.setJobcategory("software engineer");
   	job.setJobdetails("company ntt data, qualification BE, Address coimbatore");
   	job.setJobname("software developer");
   	jobDAO.save(job);
		}
	
}
