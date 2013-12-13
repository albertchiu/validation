package de.malkusch.validation.test.model.bean;

import org.joda.time.LocalDate;

import de.malkusch.validation.constraints.age.Age;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class AgeBean {

	@Age(20)
	private LocalDate birth;

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
}
