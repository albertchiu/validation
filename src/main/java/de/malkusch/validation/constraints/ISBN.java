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

import de.malkusch.validation.validator.internal.ISBNValidatorForString;

/**
 * The String has to be an ISBN.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Constraint(validatedBy={ISBNValidatorForString.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface ISBN {
	
	/**
	 * ISBN type.
	 * 
	 * @author Markus Malkusch <markus@malkusch.de>
	 */
	static public enum Type {
		/**
		 * ISBN-13
		 */
		ISBN10,
		
		/**
		 * ISBN-10
		 */
		ISBN13,
	}

	/**
	 * @return List of valid ISBN types. Default is all.
	 */
	Type[] value() default { Type.ISBN10, Type.ISBN13 };
	
	String message() default "{de.malkusch.validation.constraints.ISBN.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link ISBN} annotations on the same element.
	 * 
	 * @see ISBN
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ISBN[] value();
	}
}
