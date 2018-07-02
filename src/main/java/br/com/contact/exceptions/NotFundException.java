package br.com.contact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFundException extends RuntimeException {

	private static final long serialVersionUID = 6898870181757786559L;

	public NotFundException (String dataName) {
		super("Any "+ dataName + " as found whit this filters, please try again");
	}
	
	
}
