package com.niit.Collaboration.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="event")
public class Event {
	
	@Id
	@GeneratedValue
	private int eid;
	
	private String eventname;
	private String eventcategory;
	private String eventdatails;
	
	
	private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventcategory() {
		return eventcategory;
	}
	public void setEventcategory(String eventcategory) { 
		this.eventcategory = eventcategory;
	}
	public String getEventdatails() {
		return eventdatails; 
	}
	public void setEventdatails(String eventdatails) {
		this.eventdatails = eventdatails;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;  
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
  