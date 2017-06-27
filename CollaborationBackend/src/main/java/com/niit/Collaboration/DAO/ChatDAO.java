package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Chat;

public interface ChatDAO { 

	public List<Chat> list();
	
	public void save(Chat chat); 

	public void saveOrUpdate(Chat chat);

	public Chat getByFriendid(int cid);
	
	public void delete(int cid);
}
