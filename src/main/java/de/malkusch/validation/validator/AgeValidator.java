package de.malkusch.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.Years;

import de.malkusch.validation.constraints.age.Age;

public class AgeValidator implements ConstraintValidator<Age, ReadablePartial> {

	private int age;
	
	@Override
	public void initialize(Age constraintAnnotation) {
		age = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(ReadablePartial date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		Years age = Years.yearsBetween(date, new LocalDate());
		return ! age.isLessThan(Years.years(this.age));
	}


}
