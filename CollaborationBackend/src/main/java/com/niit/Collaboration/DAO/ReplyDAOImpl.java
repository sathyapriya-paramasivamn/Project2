package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Reply;
@Repository("ReplyDAO")   
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired   
	private SessionFactory sessionFactory;

	public ReplyDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Reply> list() {
		List<Reply> listReply = (List<Reply>) sessionFactory.getCurrentSession().createCriteria(Reply.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listReply;
	}
	@Transactional
	public void save(Reply reply) {
		sessionFactory.getCurrentSession().save(reply);
	}
	@Transactional
	public void update(Reply reply) {
		sessionFactory.getCurrentSession().update(reply);

	}
	@Transactional
	public void delete(int replyId) {
		Reply replyToDelete = new Reply();
		replyToDelete.setReplyId(replyId);
		sessionFactory.getCurrentSession().delete(replyToDelete);

	}
	
	
	@Transactional
	public Reply getByReplyId(int replyId) {
		String hql = "from Reply where replyId ='" + replyId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Reply> listReply = (List<Reply>) query.list();
		if (listReply != null && !listReply.isEmpty()) { 
			return listReply.get(0);
		}
		return null;
	}

}
