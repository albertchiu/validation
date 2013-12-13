package de.malkusch.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.malkusch.validation.constraints.banking.BIC;
import fr.marcwrobel.jbanking.bic.Bic;

public class BICValidator implements ConstraintValidator<BIC, String> {

	@Override
	public void initialize(BIC constraintAnnotation) {
	}

	@Override
	public boolean isValid(String bic, ConstraintValidatorContext context) {
		if (bic == null) {
			return true;
			
		}
		return Bic.isValid(bic);
	}

}
