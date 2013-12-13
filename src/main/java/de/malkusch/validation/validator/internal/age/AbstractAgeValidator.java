package de.malkusch.validation.validator.internal.age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.Years;

import de.malkusch.validation.constraints.age.Age;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
abstract public class AbstractAgeValidator<T> implements ConstraintValidator<Age, T> {

	private int age;
	
	abstract protected Years getAge(T date);
	
	@Override
	public void initialize(Age constraintAnnotation) {
		age = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(T date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		Years age = getAge(date);
		return ! age.isLessThan(Years.years(this.age));
	}


}
