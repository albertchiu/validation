package de.malkusch.validation.validator.jsr303.size;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * Validates a {@link Size} constraint against {@link MultipartFile}.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class SizeValidatorForMultipartFile implements ConstraintValidator<Size, MultipartFile> {
	
	private long min;
	
	private long max;

	@Override
	public void initialize(Size constraintAnnotation) {
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
