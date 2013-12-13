package de.malkusch.validation.constraints.upload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.validator.upload.SizeValidatorForMultipartFile;
import de.malkusch.validation.validator.upload.UploadSizeValidatorForMultipartFile;

/**
 * The MultipartFile's size must be in the specified boundaries (included).
 * 
 * This constraint works only on Spring's {@link MultipartFile}.
 * 
 * @deprecated Use @{@link Size} annotation. See {@link SizeValidatorForMultipartFile}
 *             for how to activate that functionality. 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UploadSizeValidatorForMultipartFile.class)
@Documented
@Deprecated
public @interface UploadSize {

	String message() default "{de.malkusch.validation.constraints.upload.UploadSize.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * @return size file size in bytes must be higher or equal to
	 */
    long min() default 0;

	/**
	 * @return size the file size in bytes must be lower or equal to
	 */
	long max() default Long.MAX_VALUE;
    
}
