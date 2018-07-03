package br.com.contact.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.contact.annotation.PhoneValidatorAnnotation;

public class PhoneValidator implements ConstraintValidator<PhoneValidatorAnnotation, String> {

	@Override
	public void initialize(PhoneValidatorAnnotation arg0) {
	}

	@Override
	public boolean isValid(String contact, ConstraintValidatorContext arg1) {
		return contact == null ||( contact != null && contact.matches("[0-9]+") && (contact.length() > 7) && (contact.length() < 14));
	}

}
