package com.niit.Collaboration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.EventDAO;

import com.niit.Collaboration.Model.Event;





@RestController
public class EventController {
	@Autowired
	private EventDAO eventDAO;
	
	
	
	
	
	@GetMapping("/event")
	public ResponseEntity<List<Event>> getEvents() {
		List<Event> listblog = eventDAO.list();
		return new ResponseEntity<List<Event>>(listblog, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/event/{id}")
	public ResponseEntity deleteEvent(@PathVariable("id") int id) {
		
		eventDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@GetMapping("/event/{id}")
	public ResponseEntity<Event>getByEid(@PathVariable("id") int id) {

		Event event = eventDAO.getByEid(id);  
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	
}
	@PostMapping("/event")
	public ResponseEntity<Event> save(@RequestBody Event event)
	{
		eventDAO.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	@PutMapping("/event")
	public ResponseEntity update(@RequestBody Event event)
	{
		eventDAO.update(event);
		return new ResponseEntity(event, HttpStatus.OK);
	}

}