package com.niit.Collaboration.DAO;

import java.util.List;


import com.niit.Collaboration.Model.Reply;

public interface ReplyDAO {
	public List<Reply> list();

	public void save(Reply reply);

	public void update(Reply reply);
    
	public void delete(int replyId);

	public Reply getByReplyId(int replyId);

}
