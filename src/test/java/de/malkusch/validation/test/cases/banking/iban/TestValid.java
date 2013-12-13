package de.malkusch.validation.test.cases.banking.iban;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.banking.IBANModel;

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
			IBANModel bean = new IBANModel();
			cases.add(new Object[] { bean });
		}
		
		{
			IBANModel bean = new IBANModel();
			bean.setIban("DE68210501700012345678");
			cases.add(new Object[] { bean });
		}
		
		return cases;
	}

}
