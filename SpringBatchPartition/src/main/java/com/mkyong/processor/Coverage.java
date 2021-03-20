package com.mkyong.processor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coverage")
@XmlAccessorType (XmlAccessType.FIELD)
public class Coverage {

	private int coverageIndicator;

	public int getCoverageIndicator() {
		return coverageIndicator;
	}

	public void setCoverageIndicator(int coverageIndicator) {
		this.coverageIndicator = coverageIndicator;
	}
}
