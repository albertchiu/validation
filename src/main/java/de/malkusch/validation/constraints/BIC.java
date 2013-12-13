package de.malkusch.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import de.malkusch.validation.validator.BICValidator;

/**
 * The String must be a valid BIC address.
 *
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy=BICValidator.class)
@Documented
public @interface BIC {

	String message() default "{de.malkusch.validation.constraints.BIC.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
