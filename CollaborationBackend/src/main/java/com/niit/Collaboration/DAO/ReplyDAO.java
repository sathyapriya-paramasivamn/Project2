 package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Reply;

public interface ReplyDAO {
	 
public List<Reply> list();
	
	public List<Reply> getReply(int id);
	
	public void save(Reply reply);
 
	public void update(Reply reply);
    
	public void delete(int replyId);  

	public Reply getByMailid(String mailid);

	public Reply getByreplyId(int replyId);	
	}
  