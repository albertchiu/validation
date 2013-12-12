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
		Class<? extends Annotation> constraint = Country.class;
		String message = "The country code is invalid.";
		{
			CountryBean bean = new CountryBean();
			String value = "xxx";
			bean.setCountry(value);
			cases.add(new Object[] {constraint, bean, value, message});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "";
			bean.setCountry(value);
			cases.add(new Object[] {constraint, bean, value, message});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "x";
			bean.setCountry(value);
			cases.add(new Object[] {constraint, bean, value, message});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "x1";
			bean.setCountry(value);
			cases.add(new Object[] {constraint, bean, value, message});
		}
		return cases;
	}

}
