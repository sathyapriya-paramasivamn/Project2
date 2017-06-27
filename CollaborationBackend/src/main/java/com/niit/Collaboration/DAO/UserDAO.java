package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.User;

public interface UserDAO {
	public List<User> list();

	public void save(User user);

	public void saveOrUpdate(User user);

	public User getById(int id);
	
	public User getByName(String name);
	
	public User getByMailid(String email);
	
	public void delete(int id);

	public User login(User user);


	 

}
