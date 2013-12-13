package de.malkusch.validation.validator.internal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.ISBNValidator;

import de.malkusch.validation.constraints.ISBN;
import de.malkusch.validation.constraints.ISBN.Type;

public class ISBNValidatorForString implements ConstraintValidator<ISBN, String> {
	
	private Set<Type> types;

	@Override
	public void initialize(ISBN constraint) {
		types = new HashSet<>(Arrays.asList(constraint.value()));
	}

	@Override
	public boolean isValid(String isbn, ConstraintValidatorContext context) {
		if (isbn == null) {
			return true;
			
		}
		if (types.contains(Type.ISBN10)) {
			if (ISBNValidator.getInstance().isValidISBN10(isbn)) {
				return true;
				
			}
		}
		if (types.contains(Type.ISBN13)) {
			if (ISBNValidator.getInstance().isValidISBN13(isbn)) {
				return true;
				
			}
		}
		return false;
	}

}
