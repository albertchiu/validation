package de.malkusch.validation.test.cases.banking.iban;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.banking.IBAN;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@IBAN
		public String getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(IBAN.class, "The IBAN address is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
		});
	}

}

