package br.com.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.contact.annotation.PhoneValidatorAnnotation;
import br.com.contact.model.enums.ContactType;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private Long idContact;

	@Column(name = "email_contact")
	@Email
	private String Emailcontact;

	@Column(name = "phone_contact")
	@PhoneValidatorAnnotation
	private String phoneContact;

	@NotNull(message = "You must inform the contact type")
	@Column(name = "contact_type")
	private ContactType contactType;

	public String getEmailcontact() {
		return Emailcontact;
	}

	public void setEmailcontact(String emailcontact) {
		Emailcontact = emailcontact;
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
