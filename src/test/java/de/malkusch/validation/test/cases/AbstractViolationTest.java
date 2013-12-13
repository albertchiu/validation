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

import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
@RunWith(Parameterized.class)
abstract public class AbstractViolationTest {
	
	private Object property;
	
	private Violation[] violations;
	
	private AbstractBean<?> bean;

	public <T>AbstractViolationTest(Class<AbstractBean<T>> beanType, T property, Violation... violations) {
		try {
			AbstractBean<T> bean = beanType.newInstance();
			bean.setProperty(property);
			
			this.bean = bean;
			this.violations = violations;
			this.property = property;
			
		} catch (InstantiationException | IllegalAccessException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testViolation() {
		Locale.setDefault(Locale.ENGLISH);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		Set<?> constraintViolations = factory.getValidator().validate(bean);

		Assert.assertEquals(constraintViolations.size(), constraintViolations.size());
		
		Set<Violation> actualViolations = new HashSet<>();
		
		for (ConstraintViolation<Object> violation : (Set<ConstraintViolation<Object>>) constraintViolations) {
			Assert.assertEquals(property, violation.getInvalidValue());
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
