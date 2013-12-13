package de.malkusch.validation.validator.upload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.NotEmptyUpload;

public class NotEmptyUploadValidator implements ConstraintValidator<NotEmptyUpload, MultipartFile> {

	@Override
	public void initialize(NotEmptyUpload constraintAnnotation) {
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		return file != null && ! file.isEmpty();
	}

}
