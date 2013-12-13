package de.malkusch.validation.validator.internal.net;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.InetAddressValidator;

import de.malkusch.validation.constraints.net.IPv4;

public class IPv4ValidatorForString implements ConstraintValidator<IPv4, String> {

	@Override
	public void initialize(IPv4 constraint) {
	}

	@Override
	public boolean isValid(String address, ConstraintValidatorContext context) {
		if (address == null) {
			return true;
			
		}
		return InetAddressValidator.getInstance().isValidInet4Address(address);
	}

}
