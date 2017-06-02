package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Collaboration.Model.Job;
@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Job> list() {
		List<Job> listJob = sessionFactory.getCurrentSession().createQuery("from Job").list();
		return listJob;
	}
	@Transactional
	public void save(Job job) {
		sessionFactory.getCurrentSession().save(job);

	}
	@Transactional
	public void update(Job job) {
		sessionFactory.getCurrentSession().update(job);

	}

	@Transactional
	public void delete(int jobid) {
		Job jobToDelete = new Job();
		jobToDelete.setJobid(jobid);
		sessionFactory.getCurrentSession().delete(jobToDelete);
	}
	@Transactional
	public Job getByJobid(int jobid){ 
		Job Jobid = (Job) sessionFactory.getCurrentSession().get(Job.class, jobid);

		return Jobid;
	}
	@Transactional
	public Job getByJobcategory(String jobcategory) {
		Job Jobcategory = (Job) sessionFactory.getCurrentSession().get(Job.class, jobcategory);

		return Jobcategory;
	}

}
