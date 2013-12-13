package de.malkusch.validation.validator.age;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;

public class AgeValidatorForReadableInstant extends AbstractAgeValidator<ReadableInstant> {

	@Override
	protected Years getAge(ReadableInstant date) {
		return Years.yearsBetween(date, new DateTime());
	}

}
