package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public void delete(int userid) {
		User userToDelete = new User();
		userToDelete.setUserid(userid);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Transactional
	public User getByUserid(int userid) {
		String hql = "from User where userid ='" + userid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;

	}

	@Transactional
	public User getByMailid(String mailid) {
		String hql = "from User where mailid ='" + mailid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	public User get(String empID) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, empID);
		return user;
	}

}
