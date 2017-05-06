package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.User;

public interface UserDAO {
	public List<User> list();

	public void save(User user);
	public void update(User user);
	public void delete(int userid);

	public User getByUserid(int userid);

	public User getByMailid(String mailid);

	public User get(String empID);
}
