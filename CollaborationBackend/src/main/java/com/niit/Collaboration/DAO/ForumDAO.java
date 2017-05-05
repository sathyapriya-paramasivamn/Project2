package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Forum;

public interface ForumDAO {

	public List<Forum>list();

	public void saveOrUpdate(Forum forum);
	public void delete (int forumid);
	public Forum getByForumid(int forumid);
	public Forum getBynName(String name);
}  
