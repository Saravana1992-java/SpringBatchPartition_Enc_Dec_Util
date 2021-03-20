package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleInfo")
@XmlAccessorType (XmlAccessType.FIELD)

public class VehicleInfo {
	private String vehicleNumber;
	private String vehicleIdentificationNumber;
	private String make;
	private String makeCode;
	private String manufacturerName;
	private String modelBodyType;
	private String modelYear;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
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
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getModelBodyType() {
		return modelBodyType;
	}
	public void setModelBodyType(String modelBodyType) {
		this.modelBodyType = modelBodyType;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	@Override
	public String toString() {
		return "VehicleInfo [vehicleNumber=" + vehicleNumber + ", vehicleIdentificationNumber="
				+ vehicleIdentificationNumber + ", make=" + make + ", makeCode=" + makeCode + ", manufacturerName="
				+ manufacturerName + ", modelBodyType=" + modelBodyType + ", modelYear=" + modelYear + "]";
	}

}
