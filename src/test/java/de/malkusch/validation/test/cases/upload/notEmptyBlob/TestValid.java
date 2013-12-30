package de.malkusch.validation.test.cases.upload.notEmptyBlob;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.upload.NotEmptyBlob;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<Blob> {
		
		@Override
		@NotEmptyBlob
		public Blob getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() throws SerialException, SQLException {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, new SerialBlob(new byte[] { 1 }) },
				{ Bean.class, new SerialBlob(new byte[] { 0 }) },
		});
	}

}