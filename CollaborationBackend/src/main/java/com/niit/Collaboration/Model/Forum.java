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
@Table(name="forum")
public class Forum {
@Id
@GeneratedValue
private int forumid;
private String name;
private String message;
private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
public String getName() {
	return name;  
}
public void setName(String name) {
	this.name = name;
}
public int getForumid() {
	return forumid;
}
public void setForumid(int forumid) {
	this.forumid = forumid;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}


}
