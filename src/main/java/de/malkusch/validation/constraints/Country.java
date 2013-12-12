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
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

/**
 * The String has to be a well formed ISO country code.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Size(min=2, max=2)
@Pattern(regexp="^[a-z]*$", flags=Flag.CASE_INSENSITIVE)
@Constraint(validatedBy={})
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Documented
public @interface Country {

	String message() default "{de.malkusch.validation.Country.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
