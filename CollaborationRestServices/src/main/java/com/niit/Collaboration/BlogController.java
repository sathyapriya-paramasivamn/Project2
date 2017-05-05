package com.niit.Collaboration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.Model.Blog;

@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;

	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	@GetMapping("/blog")
	public ResponseEntity<List<Blog>> getBlogs() {
		List<Blog> listblog = blogDAO.list();
		return new ResponseEntity<List<Blog>>(listblog, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity deleteBlog(@PathVariable("id") int blogid) {
		
		blogDAO.delete(blogid);
		return new ResponseEntity(blogid, HttpStatus.OK);
	}

	@GetMapping("/blogs/{id}")
	public ResponseEntity<Blog> getBlogByID(@PathVariable("id") int id) {
  
		Blog blog = blogDAO.getById(id);  
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	@PostMapping("/blog")
	public ResponseEntity save(@RequestBody Blog blog)
	{
		blogDAO.save(blog);
		return new ResponseEntity(blog, HttpStatus.OK);
	}
}
