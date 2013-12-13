package de.malkusch.validation.test.cases.banking.bic;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.banking.BICModel;

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
			BICModel bicBean = new BICModel();
			cases.add(new Object[] { bicBean });
		}
		
		{
			BICModel bicBean = new BICModel();
			bicBean.setBig("RAIFCH22");
			cases.add(new Object[] { bicBean });
		}
		
		return cases;
	}

}
