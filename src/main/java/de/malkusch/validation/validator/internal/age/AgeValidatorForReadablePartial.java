package de.malkusch.validation.validator.internal.age;

import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.Years;

public class AgeValidatorForReadablePartial extends AbstractAgeValidator<ReadablePartial> {

	@Override
	protected Years getAge(ReadablePartial date) {
		return Years.yearsBetween(date, new LocalDate());
	}


}
