package de.malkusch.validation.validator.internal.banking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.Base58;

import de.malkusch.validation.constraints.banking.BitcoinAddress;

public class BitcoinAddressValidatorForString implements ConstraintValidator<BitcoinAddress, String> {

	@Override
	public void initialize(BitcoinAddress constraintAnnotation) {
	}

	@Override
	public boolean isValid(String address, ConstraintValidatorContext context) {
		try {
			if (address == null) {
				return true;
				
			}
			
			// Simple validation for length, characters and the first byte.
			boolean match = address.matches("^[13][a-zA-Z1-9]{26,34}$");
			if (! match) {
				return false;
				
			}
			
			// Base58 decoding and validation of checksum.
			Base58.decodeChecked(address);
			
			return true;
			
		} catch (AddressFormatException e) {
			return false;
			
		}
	}

}
