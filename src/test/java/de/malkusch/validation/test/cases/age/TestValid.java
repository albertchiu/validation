package de.malkusch.validation.test.cases.age;

import java.util.LinkedList;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.AgeBean;

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
			AgeBean ageBean = new AgeBean();
			ageBean.setPartial(LocalDate.parse("1981-5-1"));
			cases.add(new Object[] { ageBean });
		}
		{
			AgeBean ageBean = new AgeBean();
			cases.add(new Object[] { ageBean });
		}
		{
			AgeBean ageBean = new AgeBean();
			ageBean.setInstant(DateTime.parse("1981-5-1"));
			cases.add(new Object[] { ageBean });
		}
		{
			AgeBean ageBean = new AgeBean();
			ageBean.setDate(DateTime.parse("1981-5-1").toDate());
			cases.add(new Object[] { ageBean });
		}

		return cases;
	}

}
