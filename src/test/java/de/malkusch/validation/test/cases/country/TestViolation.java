package de.malkusch.validation.test.cases.country;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.Country;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.CountryBean;

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
		Violation violation = new Violation(Country.class, "The country code is invalid.");
		{
			CountryBean bean = new CountryBean();
			String value = "xxx";
			bean.setCountry(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "";
			bean.setCountry(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "x";
			bean.setCountry(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "X1";
			bean.setCountry(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			CountryBean bean = new CountryBean();
			String value = "de";
			bean.setCountry(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
