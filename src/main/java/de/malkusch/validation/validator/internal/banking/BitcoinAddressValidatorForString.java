package de.malkusch.validation.validator.internal.banking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
			Base58.decodeChecked(address);
			return true;
			
		} catch (AddressFormatException e) {
			return false;
			
		}
	}

}
