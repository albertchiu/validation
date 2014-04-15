package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class AgeValidatorForCalendar extends AbstractAgeValidator<Calendar> {

	@Override
	protected LocalDate convert(Calendar birthday) {
		return birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
