package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class AgeValidatorForCalendar extends AbstractAgeValidator<Calendar> {
	
	@Override
	ZoneId getZoneId(Calendar context) {
		return context.getTimeZone().toZoneId();
	}
	
	@Override
	protected LocalDate convert(Calendar birthday) {
		return birthday.toInstant().atZone(birthday.getTimeZone().toZoneId()).toLocalDate();
	}

}
