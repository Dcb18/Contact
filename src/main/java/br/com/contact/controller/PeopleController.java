package br.com.contact.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contact.model.People;
import br.com.contact.service.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@PostMapping("/people")
	public ResponseEntity<People> save(@Valid @RequestBody People people) {
	    return ResponseEntity.ok(peopleService.save(people));
	}
	
	@GetMapping("/people")
	public ResponseEntity<List<People>> findAll() {
	    return ResponseEntity.ok(peopleService.findAll());
	}
	
	@GetMapping("/people/{id}")
	
	public ResponseEntity<People> findById(@PathVariable(value = "id") Long id) {
	    return ResponseEntity.ok(peopleService.findById(id));
	}
	
	@GetMapping("/people/name/{name}")
	public ResponseEntity<List<People>> findById(@PathVariable(value = "name") String name) {
	    return ResponseEntity.ok(peopleService.findByName(name));
	}
	
	@DeleteMapping("/people")
	public ResponseEntity<?> delete(@Valid @RequestBody People people){
		peopleService.delete(people);
		return ResponseEntity.ok().build();	
	}
	
}
