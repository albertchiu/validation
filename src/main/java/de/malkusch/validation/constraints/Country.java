package de.malkusch.validation.constraints;

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
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The String has to be a well formed ISO-3166-1 alpha-2 country code.
 * 
 * Those codes are upper case.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Size(min=2, max=2)
@Pattern(regexp="^[A-Z]*$")
@Constraint(validatedBy={})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Documented
public @interface Country {

	String message() default "{de.malkusch.validation.constraints.Country.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link Country} annotations on the same element.
	 * 
	 * @see (@link Country}
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Country[] value();
	}
}
