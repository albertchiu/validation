package de.malkusch.validation.constraints.banking;

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

import de.malkusch.validation.validator.internal.banking.BitcoinAddressValidatorForString;

/**
 * Validates a bitcoin address.
 *
 * @see https://en.bitcoin.it/wiki/Address
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy=BitcoinAddressValidatorForString.class)
@Documented
public @interface BitcoinAddress {

	String message() default "{de.malkusch.validation.constraints.banking.BitcoinAddress.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link BitcoinAddress} annotations on the same element.
	 * 
	 * @see BitcoinAddress
	 */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
    	BitcoinAddress[] value();
	}
    
}