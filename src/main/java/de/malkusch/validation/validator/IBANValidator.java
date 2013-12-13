package de.malkusch.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.malkusch.validation.constraints.banking.IBAN;
import fr.marcwrobel.jbanking.iban.Iban;

public class IBANValidator implements ConstraintValidator<IBAN, String> {

	@Override
	public void initialize(IBAN constraintAnnotation) {
	}

	@Override
	public boolean isValid(String iban, ConstraintValidatorContext context) {
		if (iban == null) {
			return true;
			
		}
		return Iban.isValid(iban);
	}

}
