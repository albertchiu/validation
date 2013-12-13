package de.malkusch.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import de.malkusch.validation.validator.internal.SamePropertiesValidator;

/**
 * The bean has two properties with equal values.
 * 
 * This constraint decorates a bean at class level. But if the property
 * {@link #copy()} is different to {@link #original()} a ConstraintViolation
 * will be raised on the copied property!
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = SamePropertiesValidator.class)
@Documented
public @interface SameProperties {

	String message() default "{de.malkusch.validation.constraints.SameProperties.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    /**
	 * @return property name
	 */
    String original();
    
    /**
	 * @return property name
	 */
    String copy();
	
}