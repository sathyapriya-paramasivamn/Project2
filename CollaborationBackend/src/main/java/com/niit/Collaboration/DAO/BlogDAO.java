 package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Blog;

public interface BlogDAO {
public List<Blog>list();

public void save(Blog blog);
public void update(Blog blog);
public void delete (int id);
public Blog getById(int id);
public Blog getByTitle(String title);
public Blog getByUsermailid(String usermailid);


}
