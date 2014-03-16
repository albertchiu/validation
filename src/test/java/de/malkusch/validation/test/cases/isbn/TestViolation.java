package de.malkusch.validation.test.cases.isbn;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.ISBN;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.cases.isbn.TestValid.Bean;
import de.malkusch.validation.test.cases.isbn.TestValid.ISBN10Bean;
import de.malkusch.validation.test.cases.isbn.TestValid.ISBN13Bean;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(ISBN.class, "The ISBN is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "", violations },
				{ Bean.class, "xx", violations },
				{ ISBN10Bean.class, "", violations },
				{ ISBN10Bean.class, "xx", violations },
				{ ISBN10Bean.class, "9780672327568", violations },
				{ ISBN13Bean.class, "", violations },
				{ ISBN13Bean.class, "xx", violations },
				{ ISBN13Bean.class, "0-306-40615-2", violations },
		});
	}

}
