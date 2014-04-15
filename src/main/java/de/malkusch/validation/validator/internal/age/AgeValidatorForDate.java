package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AgeValidatorForDate extends AbstractAgeValidator<Date> {

	@Override
	protected LocalDate convert(Date birthday) {
		return birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
