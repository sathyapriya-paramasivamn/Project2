package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.Model.Job;

public interface JobDAO {
	public List<Job>list();

	public void saveOrUpdate(Job job);
	public void delete (int jobid);
	public Job getByJobid(int jobid);
	public Job getByJobcategory(String jobcategory);
}
