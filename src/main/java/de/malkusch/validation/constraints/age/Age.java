package de.malkusch.validation.constraints.age;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Past;

import de.malkusch.validation.validator.internal.age.AgeValidatorForCalendar;
import de.malkusch.validation.validator.internal.age.AgeValidatorForDate;
import de.malkusch.validation.validator.internal.age.AgeValidatorForInstant;
import de.malkusch.validation.validator.internal.age.AgeValidatorForLocalDate;
import de.malkusch.validation.validator.internal.age.AgeValidatorForLocalDateTime;
import de.malkusch.validation.validator.internal.age.AgeValidatorForOffsetDateTime;
import de.malkusch.validation.validator.internal.age.AgeValidatorForPeriod;
import de.malkusch.validation.validator.internal.age.AgeValidatorForTemporalAccessor;
import de.malkusch.validation.validator.internal.age.AgeValidatorForYear;
import de.malkusch.validation.validator.internal.age.AgeValidatorForYearMonth;
import de.malkusch.validation.validator.internal.age.AgeValidatorForZonedDateTime;

/**
 * The Date must be in the past and at least that years old.
 * 
 * @author Markus Malkusch
 */
@Past
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {
		AgeValidatorForZonedDateTime.class,
		AgeValidatorForOffsetDateTime.class, AgeValidatorForYearMonth.class,
		AgeValidatorForLocalDateTime.class, AgeValidatorForYear.class,
		AgeValidatorForInstant.class, AgeValidatorForLocalDate.class,
		AgeValidatorForTemporalAccessor.class, AgeValidatorForPeriod.class,
		AgeValidatorForDate.class, AgeValidatorForCalendar.class })
@Documented
public @interface Age {

	String message() default "{de.malkusch.validation.constraints.age.Age.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    int value();
    
    /**
	 * Defines several {@link Age} annotations on the same element.
	 * 
	 * @see Age
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER  })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Age[] value();
	}
    
}
