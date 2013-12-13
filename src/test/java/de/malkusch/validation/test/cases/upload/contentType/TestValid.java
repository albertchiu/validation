package de.malkusch.validation.test.cases.upload.contentType;

import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.upload.ContentTypeBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {

	public TestValid(Object bean) {
		super(bean);
	}
	
	@Parameters
	static public Iterable<Object[]> beans() {
		LinkedList<Object[]> cases = new LinkedList<>();
		{
			ContentTypeBean bean = new ContentTypeBean();
			cases.add(new Object[] { bean });
		}
		{
			ContentTypeBean bean = new ContentTypeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{}));
			cases.add(new Object[] { bean });
		}
		{
			ContentTypeBean bean = new ContentTypeBean();
			bean.setFile(new MockMultipartFile("file", "file", "image/png", new byte[]{1}));
			cases.add(new Object[] { bean });
		}
		return cases;
	}

}
