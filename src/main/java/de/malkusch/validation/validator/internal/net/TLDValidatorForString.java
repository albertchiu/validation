package de.malkusch.validation.validator.internal.net;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.DomainValidator;

import de.malkusch.validation.constraints.net.TLD;
import de.malkusch.validation.constraints.net.TLD.TLDType;

public class TLDValidatorForString implements ConstraintValidator<TLD, String> {
	
	private Set<TLDType> types;

	@Override
	public void initialize(TLD constraint) {
		types = new HashSet<>(Arrays.asList(constraint.value()));
	}

	@Override
	public boolean isValid(String tld, ConstraintValidatorContext context) {
		if (tld == null) {
			return true;
			
		}
		if (types.contains(TLDType.COUNTRY)) {
			if (DomainValidator.getInstance().isValidCountryCodeTld(tld)) {
				return true;
				
			}
		}
		if (types.contains(TLDType.GENERIC)) {
			if (DomainValidator.getInstance().isValidGenericTld(tld)) {
				return true;
				
			}
		}
		if (types.contains(TLDType.INFRASTRUCTURE)) {
			if (DomainValidator.getInstance().isValidInfrastructureTld(tld)) {
				return true;
				
			}
		}
		if (types.contains(TLDType.LOCAL)) {
			if (DomainValidator.getInstance().isValidLocalTld(tld)) {
				return true;
				
			}
		}
		return false;
	}

}
