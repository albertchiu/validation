package de.malkusch.validation.test.cases.net.ipv4;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.IPv4;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@IPv4
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
		Violation[] violations = new Violation[]{new Violation(IPv4.class, "The internet address (v4) is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
				{ Bean.class, "10.300.0.1", violations },
		});
	}

}
