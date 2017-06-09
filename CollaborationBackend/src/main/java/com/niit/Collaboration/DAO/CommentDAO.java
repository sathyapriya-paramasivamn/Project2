package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Comment;



public interface CommentDAO {
	public List<Comment>list();

	public void save(Comment comment);
	public void update(Comment comment);
	public void delete (int cid );
	public Comment getByUsermailid(String usermailid);
}
