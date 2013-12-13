package de.malkusch.validation.test.model.bean;

import java.util.Date;

import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

import de.malkusch.validation.constraints.age.Age;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class AgeBean {

	@Age(20)
	private ReadableInstant instant;
	
	@Age(20)
	private ReadablePartial partial;
	
	@Age(20)
	private Date date;

	public ReadableInstant getInstant() {
		return instant;
	}

	public void setInstant(ReadableInstant instant) {
		this.instant = instant;
	}

	public ReadablePartial getPartial() {
		return partial;
	}

	public void setPartial(ReadablePartial partial) {
		this.partial = partial;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ReadableInstant getBirth() {
		return instant;
	}

	public void setBirth(ReadableInstant birth) {
		this.instant = birth;
	}
	
}
