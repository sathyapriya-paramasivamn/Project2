package com.niit.Collaboration.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.Model.Event;


@Repository("EventDAO")
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;
  
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}  
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Event> list() {
		List<Event> listEvent = sessionFactory.getCurrentSession().createQuery("from Event").list();
		return listEvent;
	}
	@Transactional   
	public void saveOrUpdate(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);

	}
	@Transactional
	public void delete(int eid) {
		Event eventToDelete = new Event();
		eventToDelete.setEid(eid);
		sessionFactory.getCurrentSession().delete(eventToDelete);

	}
	
	
	@Transactional
	public Event getByEventcategory(String eventcategory) {
		Event Eventcategory = (Event) sessionFactory.getCurrentSession().get(Event.class, eventcategory);
		return Eventcategory;

		
	}
	@Transactional
	public Event getByEid(int eid) {
		Event Eid = (Event) sessionFactory.getCurrentSession().get(Event.class, eid);
		return Eid;
	}

}
