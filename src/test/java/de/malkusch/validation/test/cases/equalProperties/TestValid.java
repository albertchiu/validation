package de.malkusch.validation.test.cases.equalProperties;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.EqualProperties;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {
	
	static final private String originalValue = "originalValue";
	
	@EqualProperties({"original", "original", "property"})
	public static class ThreePropertiesBean extends Bean {
		
	}

	@EqualProperties({"original", "property"})
	public static class Bean extends AbstractBean<String> {
		
		private String original = originalValue;
		
		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, originalValue },
				{ ThreePropertiesBean.class, null },
				{ ThreePropertiesBean.class, originalValue },
		});
	}

}
