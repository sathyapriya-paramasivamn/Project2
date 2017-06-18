package com.niit.Collaboration.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
   
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name ="comments")   
public class Comment {
		
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int commentId;
		
		private String commentName;
		private String content;
		private String mailid;
		
		private int userId;    
		private int forumId;
		private String forumName;
		private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		public int getCommentId() {
			return commentId;
		}
		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}
		public String getCommentName() {
			return commentName;
		}
		public void setCommentName(String commentName) {
			this.commentName = commentName;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getMailid() {
			return mailid;
		}
		public void setMailid(String mailid) {
			this.mailid = mailid;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
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
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		
	
		
}       
 