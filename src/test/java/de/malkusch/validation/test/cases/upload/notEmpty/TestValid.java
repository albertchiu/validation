package de.malkusch.validation.test.cases.upload.notEmpty;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.upload.NotEmptyBean;

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
			NotEmptyBean bean = new NotEmptyBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{1}));
			cases.add(new Object[] { bean });
		}
		return cases;
	}

}
