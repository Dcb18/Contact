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

import br.com.contact.model.Contact;
import br.com.contact.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public ResponseEntity<Contact> save(@Valid @RequestBody Contact contact) {
	    return ResponseEntity.ok(contactService.alter(contact));
	}
	
	@GetMapping("/contact")
	public ResponseEntity<List<Contact>> findAll() {
	    return ResponseEntity.ok(contactService.findAll());
	}
	
	@GetMapping("/contact/{id}")
	
	public ResponseEntity<Contact> findById(@PathVariable(value = "id") Long id) {
	    return ResponseEntity.ok(contactService.findById(id));
	}
	
	@DeleteMapping("/contact")
	public ResponseEntity<?> delete(@Valid @RequestBody Contact contact){
		contactService.delete(contact);
		return ResponseEntity.ok().build();	
	}

	
	
}
