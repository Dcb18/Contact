package br.com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.contact.exceptions.NotFundException;
import br.com.contact.model.Contact;
import br.com.contact.repository.ContactRepository;
import br.com.contact.utils.ContactUtils;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	public Contact alter(Contact contact) {
		ContactUtils.validateContact(contact);
		return contactRepository.save(contact);
	}

	public List<Contact> findAll() {
		List<Contact> contacts = contactRepository.findAll();
		if (CollectionUtils.isEmpty(contacts)) {
			throw new NotFundException("contact");
		}

		return contacts;
	}

	public Contact findById(Long id) {
		Contact contact = contactRepository.findById(id).get();
		if(contact == null) {
			throw new NotFundException("contact");
		}
		
		return contact;
	}
	
	public void delete(Contact contact) {
		contactRepository.delete(contact);
		
	}
}
