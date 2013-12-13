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

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.validator.internal.upload.NotEmptyUploadValidatorForMultipartFile;

/**
 * The MultipartFile must not be empty.
 * 
 * This constraint works only on Spring's {@link MultipartFile}.
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyUploadValidatorForMultipartFile.class)
@Documented
public @interface NotEmptyUpload {

	String message() default "{de.malkusch.validation.constraints.upload.NotEmptyUpload.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
