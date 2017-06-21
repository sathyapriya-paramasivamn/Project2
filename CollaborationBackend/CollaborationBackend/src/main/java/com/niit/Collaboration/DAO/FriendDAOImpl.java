package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Collaboration.Model.Friend;



@Repository("FriendDAO") 

public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;  
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Friend> list() {
		List<Friend> listFriend = sessionFactory.getCurrentSession().createQuery("from Friend").list();
		return listFriend;
	}

	
@Transactional
	public void delete(int fid) {
	Friend friendToDelete = new Friend();
	friendToDelete.setFid(fid);
	sessionFactory.getCurrentSession().delete(friendToDelete);

	}
@Transactional
	public Friend getByFriendid(int friendid) {
	Friend Friendid = (Friend) sessionFactory.getCurrentSession().get(Friend.class, friendid);

	return Friendid;
	}
@Transactional
public Friend getByStatus(String status) {
	Friend Status = (Friend) sessionFactory.getCurrentSession().get(Friend.class, status);

	return Status;  

}
@Transactional
public void save(Friend friend) {
	sessionFactory.getCurrentSession().save(friend);
	
}
@Transactional
public void update(Friend friend) {
	
	sessionFactory.getCurrentSession().update(friend);
}  
@Transactional
public List<Friend> getuser(int id) {
	String hql = "from User where  ='" + id + "'";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> listFriend = (List<Friend>) query.list();
	
	return listFriend;  
} 
@Transactional
public List<Friend> acceptedList() {
	String hql = "from Friend where status = " + "'A'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list = (List<Friend>) query.list();
	return list;
}
@Transactional
public List<Friend> notAcceptedList() {
	String hql = "from Friend where status = " + "'P'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list = (List<Friend>) query.list();
	return list;
	
}
}
