package br.com.contact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = -3699312528401467991L;

	public BadRequestException(String request, String cause) {
		super("The "+ request+" request can't be done, because "+ cause);
	}
}
