package br.com.contact.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import br.com.contact.validator.PhoneValidator;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneValidatorAnnotation {
	String message() default "Invalid phone number, check the size and dispense masks";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
