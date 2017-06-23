package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Forum> list() {

		// TODO Auto-generated method stub
		return null;
	}  

	@Transactional
	public Forum getByForumid(int forumid) {

		Forum Forumid = (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumid);

		return Forumid;
	}

	@Transactional
	public Forum getBynName(String name) {
		Forum Name = (Forum) sessionFactory.getCurrentSession().get(Forum.class, name);

		return Name;
	}

	@Transactional
	public void delete(int forumid) {

		Forum forumToDelete = new Forum();
		forumToDelete.setForumid(forumid);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

	@Transactional
	public void save(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);

	}

	@Transactional
	public void update(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}

	@Transactional
	public List<Forum> acceptedList() {

		String hql = "from Forum where status = " + "'A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
  
		return list;  
	}

	@Transactional  
	public List<Forum> notAcceptedList() {

		String hql = "from Forum where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		return list;  
	}  

}
