package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Friend;

public interface FriendDAO {
	public List<Friend>list();

	public void saveOrUpdate(Friend friend);
	public void delete (int fid);
	public Friend getByFid(int fid);
	public Friend getByStatus(String Status);
}
