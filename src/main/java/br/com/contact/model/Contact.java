package br.com.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.contact.annotation.PhoneValidatorAnnotation;
import br.com.contact.model.enums.ContactType;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contact", unique = true, nullable = false)
	private Long idContact;

	@Email
	@Column(name = "email_contact")
	private String emailcontact;

	@PhoneValidatorAnnotation
	@Column(name = "phone_contact")
	private String phoneContact;

	@NotNull(message = "You must inform the contact type")
	@Column(name = "contact_type")
	private ContactType contactType;

	@ManyToOne
	@JoinColumn(name = "id_people")
	@JsonIgnore
	private People people;

	
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public String getEmailcontact() {
		return emailcontact;
	}

	public void setEmailcontact(String emailcontact) {
		this.emailcontact = emailcontact;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

}
