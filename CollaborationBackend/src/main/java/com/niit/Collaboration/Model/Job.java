package com.niit.Collaboration.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="job")
public class Job { 
	@Id
	@GeneratedValue
private int jobid;	
private String jobname; 
private String jobcategory;
private String jobdetails;
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) { 
	this.jobid = jobid;
}
public String getJobname() {
	return jobname;
}
public void setJobname(String jobname) {
	this.jobname = jobname;
}
public String getJobcategory() {
	return jobcategory;
}
public void setJobcategory(String jobcategory) {
	this.jobcategory = jobcategory;
}
public String getJobdetails() {
	return jobdetails;
}
public void setJobdetails(String jobdetails) {
	this.jobdetails = jobdetails;  
}  


}
