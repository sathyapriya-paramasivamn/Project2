package com.niit.Collaboration.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
   
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name ="comments")   
public class Comment {
		
	
		@Id 
		@GeneratedValue    
		private int cid;
		private String cname;
		private String email;
		private String title;
		private int forumId;
		private String forumName;
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getForumId() {
			return forumId;
		}
		public void setForumId(int forumId) {
			this.forumId = forumId;
		}
		public String getForumName() {
			return forumName;
		}
		public void setForumName(String forumName) {
			this.forumName = forumName;
		}
		
		
		
}       
 