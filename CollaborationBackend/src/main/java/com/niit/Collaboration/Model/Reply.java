package com.niit.Collaboration.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="reply")   
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int replyId;
	private String replymsg;
	private String mailid;
	private int Id;
	private String title; 
	
	public int getReplyId() {
		return replyId; 
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplymsg() {  
		return replymsg; 
	}
	public void setReplymsg(String replymsg) {
		this.replymsg = replymsg;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getId() {
		return Id;  
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
