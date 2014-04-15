package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;

public class AgeValidatorForLocalDate extends AbstractAgeValidatorForTemporalAccessor<LocalDate> {

	@Override
	protected LocalDate convert(LocalDate birthday) {
		return birthday;
	}
	
}
