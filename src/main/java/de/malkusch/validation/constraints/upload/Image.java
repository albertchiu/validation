package de.malkusch.validation.constraints.upload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.imageio.ImageIO;
import javax.validation.Constraint;
import javax.validation.Payload;

import de.malkusch.validation.validator.upload.ImageValidator;

/**
 * The MultipartFile must be an image.
 * I.e. the file is readable by {@link ImageIO}
 * 
 * @author Markus Malkusch <markus@malkusch.de>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ImageValidator.class)
@Documented
public @interface Image {

	String message() default "{de.malkusch.validation.constraints.upload.Image.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
