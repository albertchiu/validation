package de.malkusch.validation.test.model;

import de.malkusch.validation.constraints.Country;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class CountryBean {

	@Country
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
