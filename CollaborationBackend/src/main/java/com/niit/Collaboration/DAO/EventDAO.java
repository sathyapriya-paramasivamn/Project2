package com.niit.Collaboration.DAO;

import java.util.List;


import com.niit.Collaboration.Model.Event;

public interface EventDAO {
public List<Event>list();
public void save(Event event);
public void update(Event event);
public void delete (int eid);
public Event getByEventcategory(String eventcategory);
public Event getByEid(int eid);


}  
