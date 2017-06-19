package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Blog> acceptedList() {
		String hql = "from Blog where status = " + "'A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		return list;
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
		Blog Title = (Blog) sessionFactory.getCurrentSession().get(Blog.class, title);

		return Title;
	}

	@Transactional
	public void update(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);

	}

	@Transactional
	public Blog getByUsermailid(String usermailid) {
		Blog Usermailid = (Blog) sessionFactory.getCurrentSession().get(Blog.class, usermailid);

		return Usermailid; 

	}   
	@Transactional
	public List<Blog> notAcceptedList() {
		String hql = "from Blog where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		return list; 
	} 

	public List<Blog> list() {  
		// TODO Auto-generated method stub
		return null;
	}
}
