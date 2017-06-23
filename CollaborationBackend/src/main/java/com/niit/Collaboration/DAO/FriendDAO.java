package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Friend;

public interface FriendDAO {
	public List<Friend>list();
	
	public List<Friend> list(int friendid);

    public List<Friend> acceptedList();
	public List<Friend> notAcceptedList();
	public void save(Friend friend);
	public void update(Friend friend);
	public void delete (int fid);
	public Friend getByFriendid(int friendid);
	public Friend getByStatus(String Status); 
	public List<Friend> getuser(int id);
}
