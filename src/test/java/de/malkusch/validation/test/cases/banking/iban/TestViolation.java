package de.malkusch.validation.test.cases.banking.iban;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.banking.IBAN;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.banking.IBANModel;

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
		Violation violation = new Violation(IBAN.class, "The IBAN address is invalid.");
		{
			IBANModel bean = new IBANModel();
			String value = "xxx";
			bean.setIban(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			IBANModel bean = new IBANModel();
			String value = "";
			bean.setIban(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
