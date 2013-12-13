package de.malkusch.validation.test.cases.age.adult;

import java.util.LinkedList;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.AdultBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public TestViolation(Object bean, Object value, Violation violation) {
		super(bean, value, violation);
	}

	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();
		Violation violation = new Violation(Age.class, "The Age must be at least 18 years.");
		{
			AdultBean bean = new AdultBean();
			LocalDate value = new LocalDate().minus(Days.ONE);;
			bean.setBirth(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			AdultBean bean = new AdultBean();
			LocalDate value = LocalDate.now().minus(Years.years(18)).plus(Days.days(1));
			bean.setBirth(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
