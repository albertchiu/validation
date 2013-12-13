package de.malkusch.validation.test.cases.upload.size;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.upload.SizeBean;

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
			SizeBean bean = new SizeBean();
			cases.add(new Object[] { bean });
		}
		{
			SizeBean bean = new SizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{}));
			cases.add(new Object[] { bean });
		}
		{
			SizeBean bean = new SizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{1, 2}));
			cases.add(new Object[] { bean });
		}
		{
			SizeBean bean = new SizeBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{1,2,3,4,5}));
			cases.add(new Object[] { bean });
		}
		return cases;
	}

}
