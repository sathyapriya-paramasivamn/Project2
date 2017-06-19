package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

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
	public Friend getByFid(int fid) {
	Friend Fid = (Friend) sessionFactory.getCurrentSession().get(Friend.class, fid);

	return Fid;
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


}
