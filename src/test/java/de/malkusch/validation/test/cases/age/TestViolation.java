package de.malkusch.validation.test.cases.age;

import java.util.LinkedList;

import javax.validation.constraints.Past;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AgeBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public TestViolation(Object bean, Object value, Violation... violations) {
		super(bean, value, violations);
	}

	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();
		Violation violation = new Violation(Age.class, "The Age must be at least 20 years.");
		{
			AgeBean bean = new AgeBean();
			LocalDate value = LocalDate.now().minus(Days.ONE);
			bean.setBirth(value);
			cases.add(new Object[] {bean, value, new Violation[] { violation }});
		}
		{
			AgeBean bean = new AgeBean();
			LocalDate value = new LocalDate().plusYears(5);
			bean.setBirth(value);
			cases.add(new Object[] {
					bean,
					value,
					new Violation[] {
						violation,
						new Violation(Past.class, "must be in the past")
					}});
		}
		return cases;
	}

}
