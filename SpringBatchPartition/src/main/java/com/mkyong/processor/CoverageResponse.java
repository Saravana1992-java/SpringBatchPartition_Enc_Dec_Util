package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coverage")
@XmlAccessorType(XmlAccessType.FIELD)

public class CoverageResponse {

	private String majorLineCode;
	private String statId;
	private String coverageIndicator;
	private String coverageId;
	private String policyLimit;
	private String biPerPersonLiabLimit;
	private String biPerOccurLiabLimit;
	private String medPayLimit;
	private String propertyDamageLiabLimit;
	private String comprehensiveLimit;
	private String collisionLimit;
	private String noFaultDesc;
	private String umBiPerPersonLimit;
	private String umBiPerOccurLimit;
	private String udmPerPeronLimit;
	private String udmPerOccurLimit;
	private String umpdLimit;
	private String towingLimit;
	private String fullGlassLimit;
	private String rentalReimburseLimit;
	private String deductible;
	private String statSeg3Info;

	public String getMajorLineCode() {
		return majorLineCode;
	}

	public void setMajorLineCode(String majorLineCode) {
		this.majorLineCode = majorLineCode;
	}

	public String getStatId() {
		return statId;
	}

	public void setStatId(String statId) {
		this.statId = statId;
	}

	public String getCoverageIndicator() {
		return coverageIndicator;
	}

	public void setCoverageIndicator(String coverageIndicator) {
		this.coverageIndicator = coverageIndicator;
	}

	public String getCoverageId() {
		return coverageId;
	}

	public void setCoverageId(String coverageId) {
		this.coverageId = coverageId;
	}

	public String getPolicyLimit() {
		return policyLimit;
	}

	public void setPolicyLimit(String policyLimit) {
		this.policyLimit = policyLimit;
	}

	public String getBiPerPersonLiabLimit() {
		return biPerPersonLiabLimit;
	}

	public void setBiPerPersonLiabLimit(String biPerPersonLiabLimit) {
		this.biPerPersonLiabLimit = biPerPersonLiabLimit;
	}

	public String getBiPerOccurLiabLimit() {
		return biPerOccurLiabLimit;
	}

	public void setBiPerOccurLiabLimit(String biPerOccurLiabLimit) {
		this.biPerOccurLiabLimit = biPerOccurLiabLimit;
	}

	public String getMedPayLimit() {
		return medPayLimit;
	}

	public void setMedPayLimit(String medPayLimit) {
		this.medPayLimit = medPayLimit;
	}

	public String getPropertyDamageLiabLimit() {
		return propertyDamageLiabLimit;
	}

	public void setPropertyDamageLiabLimit(String propertyDamageLiabLimit) {
		this.propertyDamageLiabLimit = propertyDamageLiabLimit;
	}

	public String getComprehensiveLimit() {
		return comprehensiveLimit;
	}

	public void setComprehensiveLimit(String comprehensiveLimit) {
		this.comprehensiveLimit = comprehensiveLimit;
	}

	public String getCollisionLimit() {
		return collisionLimit;
	}

	public void setCollisionLimit(String collisionLimit) {
		this.collisionLimit = collisionLimit;
	}

	public String getNoFaultDesc() {
		return noFaultDesc;
	}

	public void setNoFaultDesc(String noFaultDesc) {
		this.noFaultDesc = noFaultDesc;
	}

	public String getUmBiPerPersonLimit() {
		return umBiPerPersonLimit;
	}

	public void setUmBiPerPersonLimit(String umBiPerPersonLimit) {
		this.umBiPerPersonLimit = umBiPerPersonLimit;
	}

	public String getUmBiPerOccurLimit() {
		return umBiPerOccurLimit;
	}

	public void setUmBiPerOccurLimit(String umBiPerOccurLimit) {
		this.umBiPerOccurLimit = umBiPerOccurLimit;
	}

	public String getUdmPerPeronLimit() {
		return udmPerPeronLimit;
	}

	public void setUdmPerPeronLimit(String udmPerPeronLimit) {
		this.udmPerPeronLimit = udmPerPeronLimit;
	}

	public String getUdmPerOccurLimit() {
		return udmPerOccurLimit;
	}

	public void setUdmPerOccurLimit(String udmPerOccurLimit) {
		this.udmPerOccurLimit = udmPerOccurLimit;
	}

	public String getUmpdLimit() {
		return umpdLimit;
	}

	public void setUmpdLimit(String umpdLimit) {
		this.umpdLimit = umpdLimit;
	}

	public String getTowingLimit() {
		return towingLimit;
	}

	public void setTowingLimit(String towingLimit) {
		this.towingLimit = towingLimit;
	}

	public String getFullGlassLimit() {
		return fullGlassLimit;
	}

	public void setFullGlassLimit(String fullGlassLimit) {
		this.fullGlassLimit = fullGlassLimit;
	}

	public String getRentalReimburseLimit() {
		return rentalReimburseLimit;
	}

	public void setRentalReimburseLimit(String rentalReimburseLimit) {
		this.rentalReimburseLimit = rentalReimburseLimit;
	}

	public String getDeductible() {
		return deductible;
	}

	public void setDeductible(String deductible) {
		this.deductible = deductible;
	}

	public String getStatSeg3Info() {
		return statSeg3Info;
	}

	public void setStatSeg3Info(String statSeg3Info) {
		this.statSeg3Info = statSeg3Info;
	}

	@Override
	public String toString() {
		return "CoverageResponse [majorLineCode=" + majorLineCode + ", statId=" + statId + ", coverageIndicator="
				+ coverageIndicator + ", coverageId=" + coverageId + ", policyLimit=" + policyLimit
				+ ", biPerPersonLiabLimit=" + biPerPersonLiabLimit + ", biPerOccurLiabLimit=" + biPerOccurLiabLimit
				+ ", medPayLimit=" + medPayLimit + ", propertyDamageLiabLimit=" + propertyDamageLiabLimit
				+ ", comprehensiveLimit=" + comprehensiveLimit + ", collisionLimit=" + collisionLimit + ", noFaultDesc="
				+ noFaultDesc + ", umBiPerPersonLimit=" + umBiPerPersonLimit + ", umBiPerOccurLimit="
				+ umBiPerOccurLimit + ", udmPerPeronLimit=" + udmPerPeronLimit + ", udmPerOccurLimit="
				+ udmPerOccurLimit + ", umpdLimit=" + umpdLimit + ", towingLimit=" + towingLimit + ", fullGlassLimit="
				+ fullGlassLimit + ", rentalReimburseLimit=" + rentalReimburseLimit + ", deductible=" + deductible
				+ ", statSeg3Info=" + statSeg3Info + "]";
	}

}
