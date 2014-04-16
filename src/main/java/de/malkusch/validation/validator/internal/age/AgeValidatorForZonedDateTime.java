package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class AgeValidatorForZonedDateTime extends AbstractAgeValidator<ZonedDateTime> {
	
	@Override
	protected LocalDate convert(ZonedDateTime birthday) {
		return birthday.toLocalDate();
	}
	
}
