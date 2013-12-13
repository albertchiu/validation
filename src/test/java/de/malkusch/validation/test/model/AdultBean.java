package de.malkusch.validation.test.model;

import org.joda.time.LocalDate;

import de.malkusch.validation.constraints.age.Adult;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class AdultBean {

	@Adult
	private LocalDate birth;

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
}
