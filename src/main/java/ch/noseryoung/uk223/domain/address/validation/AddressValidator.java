package ch.noseryoung.uk223.domain.address.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uk223.domain.address.Address;

@Component
public class AddressValidator implements Validator {
	
	/**
	 * This Validator validates just Person instances
	 */
	public boolean supports(Class<?> clazz) {
		return Address.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "street_number", "empty_street_number");
		ValidationUtils.rejectIfEmpty(e, "street", "empty_street");
		ValidationUtils.rejectIfEmpty(e, "city", "empty_city");
		Address address = (Address) target;
		if (address.getZip().matches("^[0-9]{4}(?:-[0-9]{4})?$")) {
			e.rejectValue("zip", "incorrect_format");
		}
	}
}
