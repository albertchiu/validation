package de.malkusch.validation.test.cases.net.ipv4;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.IPv4;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@IPv4
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, "10.0.0.1" },
				{ Bean.class, "127.0.0.1" }
		});
	}

}
