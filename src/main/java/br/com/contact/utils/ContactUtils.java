package br.com.contact.utils;

import br.com.contact.exceptions.BadRequestException;
import br.com.contact.model.Contact;
import br.com.contact.model.enums.ContactType;

public class ContactUtils {
	public static final String request = "save contact people";
	public static final String causeEmail = "one of the contacts is of type email, but none has been informed"; 
	public static final String causePhone = "one of the contacts is of type phone or WhatsApp, but none has been informed"; 


	public static void validateContact(Contact contact) {
		if(ContactType.EMAIL.equals(contact.getContactType()) && contact.getEmailcontact() == null){
			throw new BadRequestException(request, causeEmail);
		}
		
		if((ContactType.WHATSAPP.equals(contact.getContactType())|| ContactType.PHONE.equals(contact.getContactType()) 
				&& contact.getPhoneContact() == null)) {
			throw new BadRequestException(request, causeEmail);
		}

	}
}
