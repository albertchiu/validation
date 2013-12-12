package de.malkusch.validation.test.cases.country;

import java.lang.annotation.Annotation;
import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.Country;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.CountryBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public TestViolation(Class<? extends Annotation> constraint,
			Object bean, Object value, String message) {
		super(constraint, bean, value, message);
	}

	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();

		{
			CountryBean bean = new CountryBean();
			String value = "xxx";
			bean.setCountry(value);
			String message = "The country code is invalid.";
			Class<? extends Annotation> constraint = Country.class;
			
			cases.add(new Object[] {constraint, bean, value, message});
		}

		return cases;
	}

}
