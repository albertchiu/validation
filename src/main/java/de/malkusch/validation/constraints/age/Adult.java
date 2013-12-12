package de.malkusch.validation.constraints.age;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.joda.time.ReadablePartial;

/**
 * The ReadablePartial must be at least 18 years old.
 * 
 * @see ReadablePartial
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Age(18)
@Constraint(validatedBy={})
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface Adult {

	String message() default "{de.malkusch.validation.constraints.age.Age.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
