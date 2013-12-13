package de.malkusch.validation.validator.internal;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.apache.commons.beanutils.PropertyUtils;

import de.malkusch.validation.constraints.SameProperties;

public class SamePropertiesValidator implements
		ConstraintValidator<SameProperties, Object> {

	private String property;

	private String repeatedProperty;

	@Override
	public void initialize(SameProperties constraint) {
		property = constraint.original();
		repeatedProperty = constraint.copy();
	}

	@Override
	public boolean isValid(Object bean,
			ConstraintValidatorContext context) {
		try {
			if (bean == null) {
				return true;

			}
			
			Object value = PropertyUtils.getSimpleProperty(bean,
					property);
			Object repeatedValue = PropertyUtils.getSimpleProperty(bean,
					repeatedProperty);
			
			if (repeatedValue == null) {
				return true;

			}

			boolean valid = repeatedValue.equals(value);
			if (valid) {
				return true;

			} else {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						context.getDefaultConstraintMessageTemplate())
						.addPropertyNode(repeatedProperty)
						.addConstraintViolation();
				return false;

			}
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new ValidationException(e);
			
		}
	}

}
