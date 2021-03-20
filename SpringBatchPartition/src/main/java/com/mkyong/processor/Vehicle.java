package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle")
@XmlAccessorType (XmlAccessType.FIELD)
public class Vehicle {

	private String vehicleIdentificationNumber;
	private String make;
	private String makeCode;
	private String modelYear;
	private Coverage coverage;
	
	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}
	public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getMakeCode() {
		return makeCode;
	}
	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public Coverage getCoverage() {
		return coverage;
	}
	public void setCoverage(Coverage coverage) {
		this.coverage = coverage;
	}
}
