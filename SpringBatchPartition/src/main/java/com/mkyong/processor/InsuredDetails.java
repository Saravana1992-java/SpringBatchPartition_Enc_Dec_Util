package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insuredDetails")
@XmlAccessorType (XmlAccessType.FIELD)

public class InsuredDetails {

	private Name name;
	private InsuredMailingAddress insuredMailingAddres;
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public InsuredMailingAddress getInsuredMailingAddres() {
		return insuredMailingAddres;
	}
	public void setInsuredMailingAddres(InsuredMailingAddress insuredMailingAddres) {
		this.insuredMailingAddres = insuredMailingAddres;
	}
	@Override
	public String toString() {
		return "InsuredDetails [name=" + name + ", insuredMailingAddres=" + insuredMailingAddres + "]";
	}
	
	
}
