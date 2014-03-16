package de.malkusch.validation.test.cases.net.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.Domain;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@Domain
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
		Violation[] violations = new Violation[]{new Violation(Domain.class, "The domain name is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
				{ Bean.class, "malkusch", violations },
				{ Bean.class, "www.ma lkusch.de", violations },
		});
	}

}
