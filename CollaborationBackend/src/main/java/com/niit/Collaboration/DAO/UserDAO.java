package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.User;

public interface UserDAO {
	public List<User> list();

	public void save(User user);

	public void update(User user);

	public void delete(int id);

	public User getByUserid(int id);

	public User getByUsermailid(String usermailid);

	public User get(String empID);

	public User login(User user);
	

	

}
