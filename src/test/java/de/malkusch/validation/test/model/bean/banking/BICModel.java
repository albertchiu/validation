package de.malkusch.validation.test.model.bean.banking;

import de.malkusch.validation.constraints.banking.BIC;

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
