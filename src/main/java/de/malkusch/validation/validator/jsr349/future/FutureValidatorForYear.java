package de.malkusch.validation.validator.jsr349.future;

import java.time.Year;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Future;

/**
 * Validates a {@link Future} constraint against {@link Year}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 * @author Markus Malkusch
 */
public class FutureValidatorForYear implements ConstraintValidator<Future, Year> {
	
	@Override
	public void initialize(Future constraintAnnotation) {
	}

	@Override
	public boolean isValid(Year date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		return date.isAfter(Year.now());
	}

}
