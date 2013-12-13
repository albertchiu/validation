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

import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

import de.malkusch.validation.validator.internal.age.AgeValidatorForCalendar;
import de.malkusch.validation.validator.internal.age.AgeValidatorForDate;
import de.malkusch.validation.validator.internal.age.AgeValidatorForReadableInstant;
import de.malkusch.validation.validator.internal.age.AgeValidatorForReadablePartial;

/**
 * The Date must be in the past and at least that years old.
 * 
 * You have to provide joda-time for this constraint.
 * 
 * @see ReadablePartial
 * @see ReadableInstant
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Past
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = { 
		AgeValidatorForReadablePartial.class, AgeValidatorForReadableInstant.class,
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
	 * @see (@link Age}
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER  })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Age[] value();
	}
    
}
