package de.malkusch.validation.test.model.bean.upload;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.Image;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class ImageBean {

	@Image
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
