package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle")
@XmlAccessorType(XmlAccessType.FIELD)

public class VehicleResponse {

	private String assignedDriverNumber;
	private VehicleInfo vehicleInfo;
	private AdditionalInterest additionalInterest;
	private CoverageResponse coverage;

	public String getAssignedDriverNumber() {
		return assignedDriverNumber;
	}

	public void setAssignedDriverNumber(String assignedDriverNumber) {
		this.assignedDriverNumber = assignedDriverNumber;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public AdditionalInterest getAdditionalInterest() {
		return additionalInterest;
	}

	public void setAdditionalInterest(AdditionalInterest additionalInterest) {
		this.additionalInterest = additionalInterest;
	}

	public CoverageResponse getCoverage() {
		return coverage;
	}

	public void setCoverage(CoverageResponse coverage) {
		this.coverage = coverage;
	}

	@Override
	public String toString() {
		return "VehicleResponse [assignedDriverNumber=" + assignedDriverNumber + ", vehicleInfo=" + vehicleInfo
				+ ", additionalInterest=" + additionalInterest + ", coverage=" + coverage + "]";
	}


}
