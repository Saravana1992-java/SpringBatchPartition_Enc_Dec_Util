package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "driver")
@XmlAccessorType(XmlAccessType.FIELD)

public class DriverDetail {

	private DriverName name;
	private int driverNumber;
	private String birthDate;
	private String licenseNumber;
	private char gender;

	public DriverName getName() {
		return name;
	}

	public void setName(DriverName name) {
		this.name = name;
	}

	public int getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(int driverNumber) {
		this.driverNumber = driverNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "DriverDetail [name=" + name + ", driverNumber=" + driverNumber + ", birthDate=" + birthDate
				+ ", licenseNumber=" + licenseNumber + ", gender=" + gender + "]";
	}


}
