package de.malkusch.validation.test.cases.country;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.CountryBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {

	public TestValid(Object bean) {
		super(bean);
	}
	
	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();

		{
			CountryBean countryBean = new CountryBean();
			cases.add(new Object[] { countryBean });
		}
		
		{
			CountryBean countryBean = new CountryBean();
			countryBean.setCountry("xx");
			cases.add(new Object[] { countryBean });
		}

		{
			CountryBean countryBean = new CountryBean();
			countryBean.setCountry("XX");
			cases.add(new Object[] { countryBean });
		}

		return cases;
	}

}
