package de.malkusch.validation.validator.internal.banking.bitcoin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.malkusch.validation.constraints.banking.BitcoinAddress;

public class BitcoinAddressValidatorForString implements ConstraintValidator<BitcoinAddress, String> {

	@Override
	public void initialize(BitcoinAddress constraintAnnotation) {
	}

	@Override
	public boolean isValid(String address, ConstraintValidatorContext context) {
		if (address == null) {
			return true;
			
		}
		
		// Simple validation for length, characters and the first byte.
		String pattern = String.format("^[13][%s]{26,34}$", Base58.ALPHABET);
		boolean match = address.matches(pattern);
		if (! match) {
			return false;
			
		}
		
		// Base58 decoding and validation of checksum.
		return Base58.isValidChecksum(address);
	}

}
