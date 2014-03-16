package de.malkusch.validation.test.cases.age.adult;

import java.util.Arrays;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.Years;
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
	
	public static class Bean extends AbstractBean<ReadablePartial> {
		
		@Override
		@Adult
		public ReadablePartial getProperty() {
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
				{ Bean.class, new LocalDate().minus(Days.ONE), violations },
				{ Bean.class, LocalDate.now().minus(Years.years(18)).plus(Days.days(1)), violations },
		});
	}

}