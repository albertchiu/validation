package de.malkusch.validation.test.model.bean;

import de.malkusch.validation.constraints.IBAN;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class IBANModel {

	@IBAN
	private String iban;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
