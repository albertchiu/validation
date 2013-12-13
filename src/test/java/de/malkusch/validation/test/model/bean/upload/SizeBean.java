package de.malkusch.validation.test.model.bean.upload;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class SizeBean {

	@Size(min = 2, max = 5)
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
