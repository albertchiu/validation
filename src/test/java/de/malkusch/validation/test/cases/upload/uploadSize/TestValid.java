package de.malkusch.validation.test.cases.upload.uploadSize;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.upload.UploadSizeBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {

	public TestValid(Object bean) {
		super(bean);
	}
	
	@Parameters
	static public Iterable<Object[]> beans() throws IOException {
		LinkedList<Object[]> cases = new LinkedList<>();
		{
			UploadSizeBean bean = new UploadSizeBean();
			cases.add(new Object[] { bean });
		}
		{
			UploadSizeBean bean = new UploadSizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{}));
			cases.add(new Object[] { bean });
		}
		{
			UploadSizeBean bean = new UploadSizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{1, 2}));
			cases.add(new Object[] { bean });
		}
		{
			UploadSizeBean bean = new UploadSizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{1,2,3,4,5}));
			cases.add(new Object[] { bean });
		}
		return cases;
	}

}
