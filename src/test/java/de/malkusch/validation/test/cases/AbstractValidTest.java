package de.malkusch.validation.test.cases;

import java.util.Set;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
@RunWith(Parameterized.class)
abstract public class AbstractValidTest {

	private AbstractBean<?> bean;

	public <T>AbstractValidTest(Class<AbstractBean<T>> beanType, T property) {
		try {
			AbstractBean<T> bean = beanType.newInstance();
			bean.setProperty(property);
			
			this.bean = bean;
			
		} catch (InstantiationException | IllegalAccessException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<?> violations = factory.getValidator().validate(bean);
		Assert.assertTrue(violations.isEmpty());
	}

}
