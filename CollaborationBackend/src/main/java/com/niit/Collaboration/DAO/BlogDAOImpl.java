package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = sessionFactory.getCurrentSession().createQuery("from Blog").list();
		return listBlog;
	}
	@Transactional
	public void save(Blog blog) {
		sessionFactory.getCurrentSession().save(blog);
		
	}  

	@Transactional
	public void delete(int id) {
		Blog blogToDelete = new Blog();
		blogToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}
	@Transactional
	public Blog getById(int id) {
		Blog Id = (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);

		return Id;
	} 
	@Transactional
	public Blog getByTitle(String title) {
		Blog Title = (Blog) sessionFactory.getCurrentSession().get(Blog.class,title);

		return Title;
	}
	@Transactional
	public void update(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		
	}  
	@Transactional
	public Blog getByUsermailid(String usermailid) {
		Blog Usermailid = (Blog) sessionFactory.getCurrentSession().get(Blog.class,usermailid);

		return Usermailid;  
	  
	} 
}
 