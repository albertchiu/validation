package de.malkusch.validation.validator.upload;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * Validates @Size constraint against MultipartFile.
 * 
 * This is an extension to the JSR-303 default constraint @Size. You have to 
 * add this validator to the list of constraint validators. This is done by
 * adding the resource META-INF/validation/mapping.xml to your Validation configuration.
 * You have to either create a META-INF/validation.xml and add that mapping or
 * you do it programmatically with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 * @see http://beanvalidation.org/1.0/spec/#xml-mapping-constraintdefinition
 * @see Size
 * @see MultipartFile
 * @author malkusch
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
