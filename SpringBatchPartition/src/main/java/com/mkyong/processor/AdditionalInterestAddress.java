package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType (XmlAccessType.FIELD)

public class AdditionalInterestAddress {

	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private String zipFive;
	private String zipFour;
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipFive() {
		return zipFive;
	}
	public void setZipFive(String zipFive) {
		this.zipFive = zipFive;
	}
	public String getZipFour() {
		return zipFour;
	}
	public void setZipFour(String zipFour) {
		this.zipFour = zipFour;
	}
	@Override
	public String toString() {
		return "AdditionalInterestAddress [addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", zipFive=" + zipFive + ", zipFour=" + zipFour + "]";
	}
	
}
