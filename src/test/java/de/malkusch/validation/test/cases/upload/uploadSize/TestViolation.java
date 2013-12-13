package de.malkusch.validation.test.cases.upload.uploadSize;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.UploadSize;
import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.upload.UploadSizeBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Deprecated
public class TestViolation extends AbstractViolationTest {
	
	public TestViolation(Object bean, Object value, Violation violation) {
		super(bean, value, violation);
	}

	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();
		Violation violation = new Violation(UploadSize.class, "The uploaded file size must be between 2 and 5 bytes.");
		{
			UploadSizeBean bean = new UploadSizeBean();
			MultipartFile value = new MockMultipartFile("image", new byte[] {1});
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			UploadSizeBean bean = new UploadSizeBean();
			MultipartFile value = new MockMultipartFile("image", new byte[] {1, 2, 3, 4, 5, 6});
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
