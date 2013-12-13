package de.malkusch.validation.test.cases.upload.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;

import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.upload.ImageBean;

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
			ImageBean bean = new ImageBean();
			cases.add(new Object[] { bean });
		}
		{
			ImageBean bean = new ImageBean();
			bean.setFile(new MockMultipartFile("file", new byte[]{}));
			cases.add(new Object[] { bean });
		}
		{
			ImageBean bean = new ImageBean();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), "jpeg", out);
			bean.setFile(new MockMultipartFile("file", out.toByteArray()));
			
			cases.add(new Object[] { bean });
		}
		return cases;
	}

}
