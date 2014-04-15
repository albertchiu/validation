package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.Year;

public class AgeValidatorForYear extends AbstractAgeValidatorForTemporalAccessor<Year> {
	
	@Override
	protected LocalDate convert(Year birthday) {
		return birthday.atDay(1);
	}
	
}
