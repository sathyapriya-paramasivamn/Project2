package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Comment; 

@Repository("CommentDAO")  
public class CommentDAOImpl implements CommentDAO {

	@Autowired   
	private SessionFactory sessionFactory;

	public CommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Comment> list() {
		@SuppressWarnings({ "unchecked" })
		List<Comment> listComment = (List<Comment>) sessionFactory.getCurrentSession().createCriteria(Comment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listComment;
	}

	@Transactional
	public void save(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	@Transactional
	public void update(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);

	}

	@Transactional
	public void delete(int cid) {
		Comment commentToDelete = new Comment();
		commentToDelete.setCommentId(cid);
		sessionFactory.getCurrentSession().delete(commentToDelete);

	}

	@Transactional
	public Comment getByMailid(String mailid) {
		String hql = "from comment where email ='" + mailid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) (query).list();

		if (listComment != null && !listComment.isEmpty()) { 
			return listComment.get(0);
		}  
		return null;
	}    
  
	@Transactional  
	public Comment getByCommentId(int commentId) {
		String hql = "from Comment where commentId ='" + commentId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) query.list();
		if (listComment != null && !listComment.isEmpty()) { 
			return listComment.get(0);
		}
		return null;
	}
	@Transactional
	public List<Comment> getComment(int forumid) {
		String hql = "from Comment where forumId ='" + forumid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) query.list();
		
		return listComment;

	}  
} 
