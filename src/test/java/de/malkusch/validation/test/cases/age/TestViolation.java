package de.malkusch.validation.test.cases.age;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.Past;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class CalendarBean extends AbstractBean<Calendar> {
		
		@Override
		@Age(20)
		public Calendar getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class PartialBean extends AbstractBean<ReadablePartial> {

		@Override
		@Age(20)
		public ReadablePartial getProperty() {
			return super.getProperty();
		}

	}
	
	public static class InstantBean extends AbstractBean<ReadableInstant> {
		
		@Override
		@Age(20)
		public ReadableInstant getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class DateBean extends AbstractBean<Date> {
		
		@Override
		@Age(20)
		public Date getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation violation = new Violation(Age.class, "The Age must be at least 20 years.");
		Violation[] violations = new Violation[]{ violation };
		Violation[] pastViolations = new Violation[]{ violation, new Violation(Past.class, "must be in the past") };
		return Arrays.asList(new Object[][] {
				{ PartialBean.class,  LocalDate.now().minus(Days.ONE), violations },
				{ InstantBean.class,  DateTime.now().minus(Days.ONE), violations },
				{ DateBean.class,     DateTime.now().minus(Days.ONE).toDate(), violations },
				{ CalendarBean.class, DateTime.now().minus(Days.ONE).toCalendar(Locale.getDefault()), violations },
				{ PartialBean.class,  LocalDate.now().plusYears(5), pastViolations },
		});
	}

}
