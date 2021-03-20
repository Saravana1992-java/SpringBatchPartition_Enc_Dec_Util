package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "additionalInterest")
@XmlAccessorType (XmlAccessType.FIELD)

public class AdditionalInterest {
	
	private String lossPayeeName;
	private String lossPayeeNumber;
	private AdditionalInterestAddress address;
	
	public String getLossPayeeName() {
		return lossPayeeName;
	}
	public void setLossPayeeName(String lossPayeeName) {
		this.lossPayeeName = lossPayeeName;
	}
	public String getLossPayeeNumber() {
		return lossPayeeNumber;
	}
	public void setLossPayeeNumber(String lossPayeeNumber) {
		this.lossPayeeNumber = lossPayeeNumber;
	}
	public AdditionalInterestAddress getAddress() {
		return address;
	}
	public void setAddress(AdditionalInterestAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AdditionalInterest [lossPayeeName=" + lossPayeeName + ", lossPayeeNumber=" + lossPayeeNumber
				+ ", address=" + address + "]";
	}

}
