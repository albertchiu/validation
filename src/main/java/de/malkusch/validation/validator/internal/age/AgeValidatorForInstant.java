package de.malkusch.validation.validator.internal.age;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class AgeValidatorForInstant extends AbstractAgeValidatorForTemporalAccessor<Instant> {
	
	@Override
	protected LocalDate convert(Instant birthday) {
		return birthday.atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
}
