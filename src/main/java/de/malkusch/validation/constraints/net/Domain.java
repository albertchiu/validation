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

import de.malkusch.validation.validator.internal.net.DomainValidatorForString;

/**
 * The String has to be a Domain.
 * 
 * @author Markus Malkusch
 */
@Constraint(validatedBy={DomainValidatorForString.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Domain {

	String message() default "{de.malkusch.validation.constraints.net.Domain.message}";
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link Domain} annotations on the same element.
	 * 
	 * @see Domain
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Domain[] value();
	}
}
