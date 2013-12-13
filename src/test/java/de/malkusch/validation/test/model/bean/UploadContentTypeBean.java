package de.malkusch.validation.test.model.bean;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.ContentType;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class UploadContentTypeBean {

	@ContentType("image/*")
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
