package de.malkusch.validation.test.cases.age;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {

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

	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] { 
				{ PartialBean.class, null },
				{ InstantBean.class, null },
				{ DateBean.class, null },
				{ CalendarBean.class, null },
				{ PartialBean.class, LocalDate.parse("1981-5-1") },
				{ InstantBean.class, DateTime.parse("1981-5-1") },
				{ DateBean.class, DateTime.parse("1981-5-1").toDate() },
				{ CalendarBean.class, DateTime.parse("1981-5-1").toCalendar(Locale.getDefault()) }
		});
	}

}

