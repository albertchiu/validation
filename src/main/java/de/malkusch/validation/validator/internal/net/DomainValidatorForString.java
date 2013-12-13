package de.malkusch.validation.validator.internal.net;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.DomainValidator;

import de.malkusch.validation.constraints.net.Domain;

public class DomainValidatorForString implements ConstraintValidator<Domain, String> {
	
	@Override
	public void initialize(Domain constraint) {
	}

	@Override
	public boolean isValid(String domain, ConstraintValidatorContext context) {
		if (domain == null) {
			return true;
			
		}
		return DomainValidator.getInstance().isValid(domain);
	}

}
