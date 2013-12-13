package de.malkusch.validation.test.cases.bic;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.BIC;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.BICModel;

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
		Violation violation = new Violation(BIC.class, "The BIC is invalid.");
		{
			BICModel bean = new BICModel();
			String value = "xxx";
			bean.setBig(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			BICModel bean = new BICModel();
			String value = "";
			bean.setBig(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
