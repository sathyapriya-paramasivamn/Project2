package com.niit.Collaboration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.JobDAO;
import com.niit.Collaboration.Model.Job;

@RestController
public class JobController {
@Autowired
private JobDAO jobDAO;

public JobDAO getJobDAO() {
	return jobDAO;
}

public void setJobDAO(JobDAO jobDAO) {
	this.jobDAO = jobDAO;
}
@GetMapping("/job")
public ResponseEntity<List<Job>> getJobs() {
	List<Job> listjob = jobDAO.list();
	return new ResponseEntity<List<Job>>(listjob, HttpStatus.OK);
}

@SuppressWarnings({ "rawtypes", "unchecked" })
@DeleteMapping("/jobs/{id}")
public ResponseEntity deleteJob(@PathVariable("id") int jobid) {
	
	jobDAO.delete(jobid);
	return new ResponseEntity(jobid, HttpStatus.OK);
}

@GetMapping("/jobs/{id}")
public ResponseEntity<Job> geByID(@PathVariable("id") int id) {

	Job job = jobDAO.getByJobid(id);  
	return new ResponseEntity<Job>(job, HttpStatus.OK);
}
}
