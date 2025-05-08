package com.tca.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class ContactNumber {

	private Integer countryCode;
	private String Number;
	
	
	public Integer getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	
	
}
