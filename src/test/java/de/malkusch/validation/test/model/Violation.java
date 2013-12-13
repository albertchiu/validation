package de.malkusch.validation.test.model;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class Violation {

	private String message;

	private Class<? extends Annotation> constraint;

	public Violation(Class<? extends Annotation> constraint, String message) {
		this.constraint = constraint;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Class<? extends Annotation> getConstraint() {
		return constraint;
	}

	public void setConstraint(Class<? extends Annotation> constraint) {
		this.constraint = constraint;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
