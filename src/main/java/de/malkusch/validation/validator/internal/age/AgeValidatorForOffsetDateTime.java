package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class AgeValidatorForOffsetDateTime extends AbstractAgeValidator<OffsetDateTime> {
	
	@Override
	protected LocalDate convert(OffsetDateTime birthday) {
		return birthday.toLocalDate();
	}
	
}
