package de.malkusch.validation.test.cases.isbn;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.ISBN;
import de.malkusch.validation.constraints.ISBN.Type;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {
	
	public static class ISBN13Bean extends AbstractBean<String> {
		
		@Override
		@ISBN(Type.ISBN13)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class ISBN10Bean extends AbstractBean<String> {
		
		@Override
		@ISBN(Type.ISBN10)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@ISBN
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
				{ Bean.class, "0-306-40615-2" },
				{ Bean.class, "9780672327568" },
				{ ISBN10Bean.class, null },
				{ ISBN10Bean.class, "0-306-40615-2" },
				{ ISBN13Bean.class, null },
				{ ISBN13Bean.class, "9780672327568" },
		});
	}

}
