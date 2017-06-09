package com.niit.Collaboration.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "comment")

public class Comment {
	
	
		@Id 
		@GeneratedValue
		private int cid;
		/*@Id
		@GeneratedValue(generator = "newGenerator")
		@GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = {
		@Parameter(value = "Blog", name = "property") })
		private String id;
		public String getId() {  
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}*/
		private String username;
		private String usermailid; 
		private String comment;
		public int getCid() {
			return cid; 
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUsermailid() {
			return usermailid;
		}
		public void setUsermailid(String usermailid) {
			this.usermailid = usermailid;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}  
  
}  
