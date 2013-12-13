package de.malkusch.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Payload;

import de.malkusch.validation.validator.internal.EqualPropertiesValidator;

/**
 * The bean has properties with equal values.
 * 
 * Add this constraint at class level and name the property names
 * which have to be equal. Set {@link #violationOnPropery()} to true
 * if you want the {@link ConstraintViolation} on each of the violating
 * properties instead of the bean. Properties which have Null values
 * don't violate against this constraint.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 * @since 0.1.0
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EqualPropertiesValidator.class)
@Documented
public @interface EqualProperties {

	String message() default "{de.malkusch.validation.constraints.EqualProperties.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return property names (at least two) which have to have equal values.
	 */
	String[] value();
	
	/**
	 * @return Set true if the violation should be propagated on the violating properties.
	 */
	boolean violationOnPropery() default false;

	/**
	 * Defines several {@link EqualProperties} annotations on the same element.
	 * 
	 * @see EqualProperties
	 */
	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EqualProperties[] value();
	}

}