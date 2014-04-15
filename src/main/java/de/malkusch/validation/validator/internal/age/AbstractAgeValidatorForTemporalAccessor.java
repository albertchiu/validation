package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;

abstract public class AbstractAgeValidatorForTemporalAccessor<T extends TemporalAccessor> extends AbstractAgeValidator<T> {
	
	@Override
	protected LocalDate convert(T birthday) {
		return LocalDate.from(birthday);
	}

}
