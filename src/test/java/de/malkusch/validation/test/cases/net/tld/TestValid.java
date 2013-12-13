package de.malkusch.validation.test.cases.net.tld;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.TLD;
import de.malkusch.validation.constraints.net.TLD.Type;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {
	
	public static class InfrastructureBean extends AbstractBean<String> {
		
		@Override
		@TLD(Type.INFRASTRUCTURE)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class GenericBean extends AbstractBean<String> {
		
		@Override
		@TLD(Type.GENERIC)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class CountryBean extends AbstractBean<String> {
		
		@Override
		@TLD(Type.COUNTRY)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class LocalBean extends AbstractBean<String> {
		
		@Override
		@TLD(Type.LOCAL)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@TLD
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
				{ Bean.class, "de" },
				{ Bean.class, "org" },
				{ Bean.class, "net" },
				{ Bean.class, "arpa" },
				{ Bean.class, "aero" },
				{ LocalBean.class, null },
				{ LocalBean.class, "localhost" },
				{ CountryBean.class, null },
				{ CountryBean.class, "de" },
				{ GenericBean.class, null },
				{ GenericBean.class, "net" },
				{ InfrastructureBean.class, null },
				{ InfrastructureBean.class, "arpa" },
		});
	}

}
