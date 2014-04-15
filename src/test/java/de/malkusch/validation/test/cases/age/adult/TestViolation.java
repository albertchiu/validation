package de.malkusch.validation.test.cases.age.adult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Adult;
import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<LocalDate> {
		
		@Override
		@Adult
		public LocalDate getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(Age.class, "The Age must be at least 18 years.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, LocalDate.now().minusDays(1), violations },
				{ Bean.class, LocalDate.now().minusYears(18).plusDays(1), violations },
		});
	}

}