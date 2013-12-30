package de.malkusch.validation.test.cases.upload.notEmptyBlob;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.upload.NotEmptyBlob;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<Blob> {
		
		@Override
		@NotEmptyBlob
		public Blob getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() throws SerialException, SQLException {
		Violation[] violations = new Violation[]{
				new Violation(NotEmptyBlob.class, "The Blob must not be empty.") };
		return Arrays.asList(new Object[][] {
				{ Bean.class, new SerialBlob(new byte[] { }), violations },
		});
	}

}
