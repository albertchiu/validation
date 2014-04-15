package de.malkusch.validation.validator.internal.age;

import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.malkusch.validation.constraints.age.Age;

/**
 * @author Markus Malkusch
 */
public class AgeValidatorForPeriod implements ConstraintValidator<Age, Period> {

	private int age;
	
	@Override
	public void initialize(Age constraintAnnotation) {
		age = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(Period period, ConstraintValidatorContext context) {
		if (period == null) {
			return true;
			
		}
		return period.getYears() >= this.age;
	}

}
