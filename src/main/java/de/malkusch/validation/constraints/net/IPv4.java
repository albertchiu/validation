package de.malkusch.validation.constraints.net;

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

import de.malkusch.validation.validator.internal.net.IPv4ValidatorForString;

/**
 * The String has to be an IPv4 address.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Constraint(validatedBy={IPv4ValidatorForString.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface IPv4 {

	String message() default "{de.malkusch.validation.constraints.net.IPv4.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link IPv4} annotations on the same element.
	 * 
	 * @see IPv4
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		IPv4[] value();
	}
}
