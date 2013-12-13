package de.malkusch.validation.test.cases.age.adult;

import java.util.LinkedList;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.AdultBean;

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
			AdultBean ageBean = new AdultBean();
			ageBean.setBirth(LocalDate.now().minus(Years.years(18)));
			cases.add(new Object[] { ageBean });
		}
		{
			AdultBean ageBean = new AdultBean();
			ageBean.setBirth(LocalDate.now().minus(Years.years(50)));
			cases.add(new Object[] { ageBean });
		}
		{
			AdultBean ageBean = new AdultBean();
			cases.add(new Object[] { ageBean });
		}
		
		return cases;
	}

}
