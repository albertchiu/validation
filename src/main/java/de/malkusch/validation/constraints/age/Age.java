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
import javax.validation.constraints.Past;

import org.joda.time.ReadablePartial;

import de.malkusch.validation.validator.AgeValidator;

/**
 * The ReadablePartial must be in the past and at least that years old.
 * 
 * @see ReadablePartial
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Past
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface Age {

	String message() default "{de.malkusch.validation.constraints.age.Age.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    int value();
    
}
