package de.malkusch.validation.test.cases.age;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Age;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch
 */
public class TestValid extends AbstractValidTest {

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

	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		
		return Arrays.asList(new Object[][] { 
				{ LocalDateBean.class, null },
				{ DateBean.class, null },
				{ CalendarBean.class, null },
				{ LocalDateBean.class, LocalDate.parse("1981-05-03") },
				{ DateBean.class, Date.from(Instant.parse("1981-05-02T10:15:30.00Z")) },
				{ CalendarBean.class, new Calendar.Builder().setDate(1981, 1, 5).build() }
		});
	}

}

