package de.malkusch.validation.test.cases;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
@RunWith(Parameterized.class)
abstract public class AbstractViolationTest {
	
	private Object value;
	
	private Class<? extends Annotation> constraint;
	
	private Object bean;
	
	private String message;
	
	public AbstractViolationTest(Class<? extends Annotation> constraint, Object bean, Object value, String message) {
		this.constraint = constraint;
		this.bean = bean;
		this.value = value;
		this.message = message;
	}
	
	@Test
	public void testValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Set<ConstraintViolation<Object>> violations = factory.getValidator()
				.validate(bean);

		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Object> violation = violations.iterator().next();
		Assert.assertEquals(value, violation.getInvalidValue());
		Assert.assertEquals(message, violation.getMessage());
		Assert.assertEquals(constraint, violation.getConstraintDescriptor().getAnnotation().annotationType());
	}

}
