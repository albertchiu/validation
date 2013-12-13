package de.malkusch.validation.validator.age;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;

public class ReadableInstantAgeValidator extends AbstractAgeValidator<ReadableInstant> {

	@Override
	protected Years getAge(ReadableInstant date) {
		return Years.yearsBetween(date, new DateTime());
	}

}
