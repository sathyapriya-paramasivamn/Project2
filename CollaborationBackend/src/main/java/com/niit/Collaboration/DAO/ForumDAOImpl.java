package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Forum> list() {
		List<Forum> listForum = sessionFactory.getCurrentSession().createQuery("from Forum").list();
		return listForum;
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
		sessionFactory.getCurrentSession().update(forum);
	}

}
