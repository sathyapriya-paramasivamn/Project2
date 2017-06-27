package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Chat;
@Repository("ChatDAO")
public class ChatDAOImpl implements ChatDAO {  
	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<Chat> list() {
		@SuppressWarnings("unchecked")
		List<Chat> chatList = sessionFactory.getCurrentSession().createQuery("from Chat").list();
		return chatList;
		
	} 

	@Transactional
	public void save(Chat chat) {
		sessionFactory.getCurrentSession().save(chat);
	}

	@Transactional
	public void saveOrUpdate(Chat chat) {
		sessionFactory.getCurrentSession().saveOrUpdate(chat);
	}

	@Transactional
	public Chat getByFriendid(int cid) {
		Chat chatListByID = (Chat) sessionFactory.getCurrentSession().get(Chat.class, cid);

		return chatListByID;

}

	@Transactional
	public void delete(int cid) {
		sessionFactory.getCurrentSession().delete(cid);
	}  

}
