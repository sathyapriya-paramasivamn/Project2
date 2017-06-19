package com.niit.Collaboration.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.DAO.BlogDAOImpl;
import com.niit.Collaboration.DAO.CommentDAO;
import com.niit.Collaboration.DAO.CommentDAOImpl;
import com.niit.Collaboration.DAO.EventDAO;
import com.niit.Collaboration.DAO.EventDAOImpl;
import com.niit.Collaboration.DAO.ForumDAO;
import com.niit.Collaboration.DAO.ForumDAOImpl;
import com.niit.Collaboration.DAO.FriendDAO;
import com.niit.Collaboration.DAO.FriendDAOImpl;
import com.niit.Collaboration.DAO.JobDAO;
import com.niit.Collaboration.DAO.JobDAOImpl;
import com.niit.Collaboration.DAO.ReplyDAO;
import com.niit.Collaboration.DAO.ReplyDAOImpl;
import com.niit.Collaboration.DAO.UserDAO;
import com.niit.Collaboration.DAO.UserDAOImpl;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Comment;
import com.niit.Collaboration.Model.Event;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.Friend;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Model.Reply;
import com.niit.Collaboration.Model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Autowired  
	@Bean(name = "dataSource")  
	public DataSource getOracleDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("SYSTEM1");     
		dataSource.setPassword("sa");  
  
		return dataSource;   
	}
  
	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");

		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Autowired  
	@Bean(name = "sessionFactory")  
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(User.class); 
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		sessionBuilder.addAnnotatedClasses(Reply.class);
		
		return sessionBuilder.buildSessionFactory();
	}
  
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
   
	@Autowired(required = true)
	@Bean(name = "blogDAO")  
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		return new BlogDAOImpl(sessionFactory);
	} 
  
	@Autowired(required = true)
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired(required = true)
	@Bean(name = "eventDAO")
	public EventDAO getEventDAO(SessionFactory sessionFactory) {
		return new EventDAOImpl(sessionFactory);
	}   
	@Autowired(required = true)  
	@Bean(name = "friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory) {
		return new FriendDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "forumDAO")    
	public ForumDAO getForumDAO(SessionFactory sessionFactory) {
		return new ForumDAOImpl(sessionFactory);
	}  
	@Autowired(required = true)    
	@Bean(name = "jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory) {
		return new JobDAOImpl(sessionFactory);
	}   
	@Autowired(required = true)  
	@Bean(name = "commentDAO")  
	public CommentDAO getCommentDAO(SessionFactory sessionFactory) {
		return new CommentDAOImpl(sessionFactory);
	}    
	@Autowired(required = true)  
	@Bean(name = "replyDAO")  
	public ReplyDAO getReplyDAO(SessionFactory sessionFactory) {
		return new ReplyDAOImpl(sessionFactory);
	}    
} 

   