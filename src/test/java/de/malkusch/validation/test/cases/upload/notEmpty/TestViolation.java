package de.malkusch.validation.test.cases.upload.notEmpty;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.NotEmptyUpload;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.upload.NotEmptyBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestViolation extends AbstractViolationTest {
	
	public TestViolation(Object bean, Object value, Violation violation) {
		super(bean, value, violation);
	}

	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();
		Violation violation = new Violation(NotEmptyUpload.class, "The uploaded file must not be empty.");
		{
			NotEmptyBean bean = new NotEmptyBean();
			MultipartFile value = new MockMultipartFile("image", new byte[] {});
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			NotEmptyBean bean = new NotEmptyBean();
			MultipartFile value = null;
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
