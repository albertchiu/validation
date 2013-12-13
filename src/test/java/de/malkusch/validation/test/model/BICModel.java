package de.malkusch.validation.test.model;

import de.malkusch.validation.constraints.BIC;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class BICModel {

	@BIC
	private String big;

	public String getBig() {
		return big;
	}

	public void setBig(String big) {
		this.big = big;
	}

}
