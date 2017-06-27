package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Friend;

public interface FriendDAO {
	public List<Friend> list();

	public List<Friend> list(int friendId);

	public void save(Friend friend);

	public Friend saveOrUpdate(Friend friend);

	public Friend getByFriendid(int id);

	public List<Friend> getByFriendName(String name);

	public List<Friend> getByFriendAccepted(String name);

	public void delete(int id);

}
