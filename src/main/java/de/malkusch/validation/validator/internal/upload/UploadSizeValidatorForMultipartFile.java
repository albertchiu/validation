package de.malkusch.validation.validator.internal.upload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.UploadSize;
import de.malkusch.validation.validator.jsr349.size.SizeValidatorForMultipartFile;

/**
 * @deprecated use {@link SizeValidatorForMultipartFile}. 
 * @author malkusch
 */
@Deprecated
public class UploadSizeValidatorForMultipartFile implements ConstraintValidator<UploadSize, MultipartFile> {
	
	private long min;
	
	private long max;

	@Override
	public void initialize(UploadSize constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		if (file == null || file.isEmpty()) {
			return true;
			
		}
		long size = file.getSize();
		return min <= size && size <= max;
	}

}
