package de.malkusch.validation.validator.internal.age;


import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Years;

public class AgeValidatorForCalendar extends AbstractAgeValidator<Calendar> {

	@Override
	protected Years getAge(Calendar calendar) {
		return Years.yearsBetween(new DateTime(calendar), new DateTime());
	}

}
