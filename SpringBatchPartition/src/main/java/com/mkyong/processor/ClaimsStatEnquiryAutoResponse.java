package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "claimsStatEnquiryAutoResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimsStatEnquiryAutoResponse {

	private String accidentDate;
	private String returnCode;
	private String producerCode;
	private String agencyCode;
	private String effectiveDate;
	private String expirationDate;
	private char policyStatusCd;
	private String policyStatusDesc;
	private String policyAnnualMonth;
	private String marketingCampaignCode;
	private String companyCd;
	private String stateCd;
	private String lapseStatus;
	private PolicyDetail policyNumber;
	private InsuredDetails insuredDetails;
	private DriverDetail driver;
	private VehicleResponse vehicle;

	public String getProducerCode() {
		return producerCode;
	}

	public void setProducerCode(String producerCode) {
		this.producerCode = producerCode;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getPolicyAnnualMonth() {
		return policyAnnualMonth;
	}

	public void setPolicyAnnualMonth(String policyAnnualMonth) {
		this.policyAnnualMonth = policyAnnualMonth;
	}

	public String getMarketingCampaignCode() {
		return marketingCampaignCode;
	}

	public void setMarketingCampaignCode(String marketingCampaignCode) {
		this.marketingCampaignCode = marketingCampaignCode;
	}

	public String getLapseStatus() {
		return lapseStatus;
	}

	public void setLapseStatus(String lapseStatus) {
		this.lapseStatus = lapseStatus;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public char getPolicyStatusCd() {
		return policyStatusCd;
	}

	public void setPolicyStatusCd(char policyStatusCd) {
		this.policyStatusCd = policyStatusCd;
	}

	public String getPolicyStatusDesc() {
		return policyStatusDesc;
	}

	public void setPolicyStatusDesc(String policyStatusDesc) {
		this.policyStatusDesc = policyStatusDesc;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public PolicyDetail getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(PolicyDetail policyNumber) {
		this.policyNumber = policyNumber;
	}

	public InsuredDetails getInsuredDetails() {
		return insuredDetails;
	}

	public void setInsuredDetails(InsuredDetails insuredDetails) {
		this.insuredDetails = insuredDetails;
	}

	public DriverDetail getDriver() {
		return driver;
	}

	public void setDriver(DriverDetail driver) {
		this.driver = driver;
	}

	public VehicleResponse getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleResponse vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "ClaimsStatEnquiryAutoResponse [accidentDate=" + accidentDate + ", returnCode=" + returnCode
				+ ", producerCode=" + producerCode + ", agencyCode=" + agencyCode + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + ", policyStatusCd=" + policyStatusCd + ", policyStatusDesc="
				+ policyStatusDesc + ", policyAnnualMonth=" + policyAnnualMonth + ", marketingCampaignCode="
				+ marketingCampaignCode + ", companyCd=" + companyCd + ", stateCd=" + stateCd + ", lapseStatus="
				+ lapseStatus + ", policyNumber=" + policyNumber + ", insuredDetails=" + insuredDetails + ", driver="
				+ driver + ", vehicle=" + vehicle + "]";
	}

}
