package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "policyNumber")
@XmlAccessorType (XmlAccessType.FIELD)

public class PolicyDetail {
	
	private String regionalOfficeCd;
	private String policySymbolCd;
	private String policyUniqueNumber;
	public String getRegionalOfficeCd() {
		return regionalOfficeCd;
	}
	public void setRegionalOfficeCd(String regionalOfficeCd) {
		this.regionalOfficeCd = regionalOfficeCd;
	}
	public String getPolicySymbolCd() {
		return policySymbolCd;
	}
	public void setPolicySymbolCd(String policySymbolCd) {
		this.policySymbolCd = policySymbolCd;
	}
	public String getPolicyUniqueNumber() {
		return policyUniqueNumber;
	}
	public void setPolicyUniqueNumber(String policyUniqueNumber) {
		this.policyUniqueNumber = policyUniqueNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((policySymbolCd == null) ? 0 : policySymbolCd.hashCode());
		result = prime * result + ((policyUniqueNumber == null) ? 0 : policyUniqueNumber.hashCode());
		result = prime * result + ((regionalOfficeCd == null) ? 0 : regionalOfficeCd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyDetail other = (PolicyDetail) obj;
		if (policySymbolCd == null) {
			if (other.policySymbolCd != null)
				return false;
		} else if (!policySymbolCd.equals(other.policySymbolCd))
			return false;
		if (policyUniqueNumber == null) {
			if (other.policyUniqueNumber != null)
				return false;
		} else if (!policyUniqueNumber.equals(other.policyUniqueNumber))
			return false;
		if (regionalOfficeCd == null) {
			if (other.regionalOfficeCd != null)
				return false;
		} else if (!regionalOfficeCd.equals(other.regionalOfficeCd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PolicyDetail [regionalOfficeCd=" + regionalOfficeCd + ", policySymbolCd=" + policySymbolCd
				+ ", policyUniqueNumber=" + policyUniqueNumber + "]";
	}
	
	

}
