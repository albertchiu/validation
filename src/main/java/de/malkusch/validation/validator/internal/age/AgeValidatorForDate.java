package de.malkusch.validation.validator.internal.age;


import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Years;

public class AgeValidatorForDate extends AbstractAgeValidator<Date> {

	@Override
	protected Years getAge(Date date) {
		return Years.yearsBetween(new DateTime(date), new DateTime());
	}

}
