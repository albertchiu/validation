package de.malkusch.validation.validator.upload;

import javax.mail.internet.ParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.ContentType;

public class ContentTypeValidator implements ConstraintValidator<ContentType, MultipartFile> {
	
	private javax.mail.internet.ContentType contentType;

	@Override
	public void initialize(ContentType constraintAnnotation) {
		try {
			contentType = new javax.mail.internet.ContentType(constraintAnnotation.value());
			
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
			
		}
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		if (file == null || file.isEmpty()) {
			return true;
			
		}
		return contentType.match(file.getContentType());
	}

}
