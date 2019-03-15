package ch.noseryoung.uk223.domain.user.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uk223.domain.user.User;

@Component
public class UserValidator implements Validator {
	
	/**
	 * This Validator validates just Person instances
	 */
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "firstName", "empty_firstName");
		ValidationUtils.rejectIfEmpty(e, "lastName", "empty_lastName");
		ValidationUtils.rejectIfEmpty(e, "username", "empty_username");
		ValidationUtils.rejectIfEmpty(e, "email", "empty_email");
		User user = (User) target;
		if (user.getPassword().length() < 8) {
			e.rejectValue("password", "length_too_short");
		}
		if (!user.getEmail().contains("@")) {
			e.rejectValue("email", "no_valid_email");
		}
	}
}
