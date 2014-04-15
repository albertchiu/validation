package de.malkusch.validation.test.cases.age;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class CalendarBean extends AbstractBean<Calendar> {
		
		@Override
		@Age(20)
		public Calendar getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class LocalDateBean extends AbstractBean<LocalDate> {

		@Override
		@Age(20)
		public LocalDate getProperty() {
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
		LocalDate yesterday = LocalDate.now().minusDays(1);
		Date yesterdayDate = Date.from(Instant.from(yesterday.atStartOfDay(ZoneId.systemDefault())));
		return Arrays.asList(new Object[][] {
				{ LocalDateBean.class,  yesterday, violations },
				{ DateBean.class,     yesterdayDate, violations },
				{ CalendarBean.class, new Calendar.Builder().setInstant(yesterdayDate).build(), violations },
				{ LocalDateBean.class,  LocalDate.now().plusYears(5), pastViolations },
		});
	}

}
