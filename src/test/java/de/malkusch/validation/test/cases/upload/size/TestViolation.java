package de.malkusch.validation.test.cases.upload.size;

import java.util.LinkedList;

import javax.validation.constraints.Size;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.test.cases.AbstractViolationTest;
import de.malkusch.validation.test.model.Violation;
import de.malkusch.validation.test.model.bean.upload.SizeBean;

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
		Violation violation = new Violation(Size.class, "size must be between 2 and 5");
		{
			SizeBean bean = new SizeBean();
			MultipartFile value = new MockMultipartFile("image", new byte[] {1});
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		{
			SizeBean bean = new SizeBean();
			MultipartFile value = new MockMultipartFile("image", new byte[] {1, 2, 3, 4, 5, 6});
			bean.setFile(value);
			cases.add(new Object[] {bean, value, violation});
		}
		return cases;
	}

}
