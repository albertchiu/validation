package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.malkusch.validation.constraints.age.Age;

/**
 * @author Markus Malkusch
 */
abstract public class AbstractAgeValidator<T> implements ConstraintValidator<Age, T> {

	private AgeValidatorForPeriod periodValidator = new AgeValidatorForPeriod();
	
	abstract protected LocalDate convert(T birthday);
	
	@Override
	public void initialize(Age constraintAnnotation) {
		periodValidator.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(T birthday, ConstraintValidatorContext context) {
		if (birthday == null) {
			return true;
			
		}
		Period age = Period.between(convert(birthday), LocalDate.now());
		return periodValidator.isValid(age, context);
	}
	
}
