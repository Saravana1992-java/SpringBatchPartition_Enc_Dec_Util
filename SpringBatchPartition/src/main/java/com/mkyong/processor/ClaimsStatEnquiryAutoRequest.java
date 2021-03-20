package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "claimsStatEnquiryAutoRequest")
@XmlAccessorType (XmlAccessType.FIELD)
public class ClaimsStatEnquiryAutoRequest {

	private String accidentDate;
	private String policyNumber;
	private String producerCode;
	private Vehicle vehicle;
	
	public String getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getProducerCode() {
		return producerCode;
	}
	public void setProducerCode(String producerCode) {
		this.producerCode = producerCode;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
