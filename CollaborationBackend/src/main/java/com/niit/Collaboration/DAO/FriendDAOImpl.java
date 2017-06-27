package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Collaboration.Model.Friend;
 


@Repository("FriendDAO")  
 
public class FriendDAOImpl implements FriendDAO  {
	@Autowired
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Friend> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Friend> friendList = sessionFactory.getCurrentSession().createQuery("from Friend").list();
		return friendList;
	}

	@Transactional
	public void save(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(friend);
	}

	@Transactional
	public Friend saveOrUpdate(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return friend;
	}

	@Transactional
	public Friend getByFriendid(int id) {
		// TODO Auto-generated method stub
		Friend friendListByID = (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);

		return friendListByID;

	}

	@Transactional
	public void delete(int fid) {
		// TODO Auto-generated method stub
		Friend friendToDelete = new Friend();
		friendToDelete.setFid(fid);
		sessionFactory.getCurrentSession().delete(friendToDelete);
	}

	@Transactional
	public List<Friend> getByFriendName(String name) {
		String hql = "from Friend where friendname =" + "'" + name + "' and status = " + "'P'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}
	
	@Transactional
	public List<Friend> getByFriendAccepted(String name){
		String hql = "from Friend where friendname =" + "'" + name + "' and status = " + "'A'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}
	
	@Transactional
	public List<Friend> list(int userId) {
		String hql = "from Friend where userid =" + "'" + userId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();

		return listFriend;
	}

}