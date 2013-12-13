package de.malkusch.validation.test.cases.net.tld;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.TLD;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.cases.net.tld.TestValid.Bean;
import de.malkusch.validation.test.cases.net.tld.TestValid.CountryBean;
import de.malkusch.validation.test.cases.net.tld.TestValid.GenericBean;
import de.malkusch.validation.test.cases.net.tld.TestValid.InfrastructureBean;
import de.malkusch.validation.test.cases.net.tld.TestValid.LocalBean;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(TLD.class, "The top level domain is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "malkusch", violations },
				{ Bean.class, "", violations },
				{ LocalBean.class, "de", violations },
				{ LocalBean.class, "", violations },
				{ GenericBean.class, "de", violations },
				{ GenericBean.class, "", violations },
				{ CountryBean.class, "net", violations },
				{ CountryBean.class, "", violations },
				{ InfrastructureBean.class, "net", violations },
				{ InfrastructureBean.class, "", violations },
		});
	}

}
