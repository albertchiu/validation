package de.malkusch.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.YearMonth;

public class AgeValidatorForYearMonth extends AbstractAgeValidator<YearMonth> {
	
	@Override
	protected LocalDate convert(YearMonth birthday) {
		return birthday.atDay(1);
	}
	
}
