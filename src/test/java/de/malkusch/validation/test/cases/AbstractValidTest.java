package de.malkusch.validation.test.cases;

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
abstract public class AbstractValidTest {

	private Object bean;

	public AbstractValidTest(Object bean) {
		this.bean = bean;
	}

	@Test
	public void testValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Set<ConstraintViolation<Object>> violations = factory.getValidator()
				.validate(bean);

		Assert.assertTrue(violations.isEmpty());
	}

}
