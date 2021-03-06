package de.malkusch.validation.test.cases.upload.notEmptyUpload;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.NotEmptyUpload;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.AbstractBean;
import de.malkusch.validation.test.model.Violation;

/**
 * @author Markus Malkusch
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@NotEmptyUpload
		public MultipartFile getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{
				new Violation(NotEmptyUpload.class, "The uploaded file must not be empty.") };
		return Arrays.asList(new Object[][] {
				{ Bean.class, new MockMultipartFile("image", new byte[] {}), violations },
				{ Bean.class, null, violations },
		});
	}

}
