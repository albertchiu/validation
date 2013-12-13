package de.malkusch.validation.test.cases.equalProperties;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.junit.Assert;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.EqualProperties;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	static final private String originalValue = "originalValue";

	@EqualProperties({"original", "property"})
	public static class Bean extends AbstractBean<String> {
		
		private String original = originalValue;
		
		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(EqualProperties.class, "The properties are not equal.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
		});
	}
	
	@Override
	protected void testInvalidValue(ConstraintViolation<Object> violation) {
		Assert.assertEquals(bean, violation.getInvalidValue());
	}

}
