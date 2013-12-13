package de.malkusch.validation.test.cases;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
@RunWith(Parameterized.class)
abstract public class AbstractViolationTest {
	
	private Object value;
	
	private Violation[] violations;
	
	private Object bean;
	
	public AbstractViolationTest(Object bean, Object value, Violation... violations) {
		this.bean = bean;
		this.value = value;
		this.violations = violations;
	}
	
	@Test
	public void testViolation() {
		Locale.setDefault(Locale.ENGLISH);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		Set<ConstraintViolation<Object>> constraintViolations = factory.getValidator()
				.validate(bean);

		Assert.assertEquals(constraintViolations.size(), constraintViolations.size());
		
		Set<Violation> actualViolations = new HashSet<>();
		
		for (ConstraintViolation<Object> violation : constraintViolations) {
			Assert.assertEquals(value, violation.getInvalidValue());
			Assert.assertEquals(
					String.format("{%s.message}", violation.getConstraintDescriptor().getAnnotation().annotationType().getName()),
					violation.getMessageTemplate());
			
			actualViolations.add(new Violation(
					violation.getConstraintDescriptor().getAnnotation().annotationType(),
					violation.getMessage()));
		}
		
		Assert.assertEquals(
				new HashSet<>(Arrays.asList(violations)),
				actualViolations);
	}

}
