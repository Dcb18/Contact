package br.com.contact.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.contact.exceptions.NotFundException;
import br.com.contact.model.Contact;
import br.com.contact.model.People;
import br.com.contact.repository.PeopleRepository;
import br.com.contact.utils.ContactUtils;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private ContactService contactService;
	
	@Transactional
	public People save(People people) {
		peopleRepository.save(people);
		if (!CollectionUtils.isEmpty(people.getPeopleContact())) {
			for (Contact contact : people.getPeopleContact()) {
				ContactUtils.validateContact(contact);
				contact.setPeople(people);
				contactService.save(contact);		
			}
		}
		return people;
	}

	@Transactional
	public List<People> findAll() {
		List<People> peoples = peopleRepository.findAll();
		if (CollectionUtils.isEmpty(peoples)) {
			throw new NotFundException("people");
		}

		return peoples;
	}
	
	@Transactional
	public People findById(Long id) {
		People people = peopleRepository.findById(id).isPresent() ? peopleRepository.findById(id).get() : null;
		if (people == null) {
			throw new NotFundException("people");
		}
		return people;
	}
	
	@Transactional
	public List<People> findByName(String name) {
		List<People> peoples = peopleRepository.findByName(name);
		if (CollectionUtils.isEmpty(peoples)) {
			throw new NotFundException("people");
		}
		return peoples;
	}
	
	@Transactional
	public void delete(People people) {
		peopleRepository.delete(people);
	}

}
