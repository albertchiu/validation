package de.malkusch.validation.test.model.bean.upload;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.UploadSize;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class UploadSizeBean {

	@UploadSize(min = 2, max = 5)
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
