package com.mkyong.processor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.mkyong.User;

public class UserProcessor implements ItemProcessor<User, User> {

	private String threadName;
	private String wsdlDocumentUrl;
	private int retryLimit;

	private String problemCode = "return_code";
	private String agencyCampaignNumber = "agency";
	private String policyEffectiveDate = "poleff";
	private String policyExpirationDate = "polexp";
	private String dedperhig = "dedperhig";
	private String qatVin = "qtvn";
	private String insNameShort = "insshort";
	private String insNameFill = "insrem";
	private String insStreet = "insstrt";
	private String insCity = "inscty";
	private String insState = "inssta";
	private String zipFirst = "inszip";
	/* private String zipLast"; */
	private String autoNumber = "autonum";
	private String writtingCompany = "writcomp";
	private String stateCode = "statcde";
	private String majorLine = "majorlne";
	private String statId = "stid";
	private String statSeg3Info = "statseginfo1";
	private String statSeg3Info2nd = "statseginfo2";
	private String statSeg3Info3rd = "statseginfo3";
	private String statSeg3Info4th = "statseginfo4";
	private String autoEndTs = "autends";
	private String detailfill = String.format("%-22s", "");
	private String errordetailfill = String.format("%-505s", "");

	public int getRetryLimit() {
		return retryLimit;
	}

	public void setRetryLimit(int retryLimit) {
		this.retryLimit = retryLimit;
	}

	@Override
	public User process(User item) throws Exception {

		System.out.println(threadName + " processing : " + item.getId() + " : " + item.getUsername());
		if (threadName.equals("3")) {
			return null;
		}

		// if (threadName.equals("1")) {
		String response = StatCodeServiceConnector.getInstance().getStatCode(getRequest(), wsdlDocumentUrl, retryLimit);
		// System.out.println("== response == \n" + response);
		if (response != null && !response.isEmpty()) {
			response = response.replaceAll("&", "&amp;");
			Element element = (Element) StatCodeServiceConnector.parseXmlFile(response, false)
					.getElementsByTagNameNS("*", "claimsStatEnquiryAutoResponse").item(0);
			ClaimsStatEnquiryAutoResponse claimsStatEnquiryAutoResponse = (ClaimsStatEnquiryAutoResponse) StatCodeServiceConnector
					.unmarshall(element, ClaimsStatEnquiryAutoResponse.class);

			// System.out.println("== claimsStatEnquiryAutoResponse == \n" +
			// claimsStatEnquiryAutoResponse);

			problemCode = claimsStatEnquiryAutoResponse.getReturnCode();
			agencyCampaignNumber = claimsStatEnquiryAutoResponse.getMarketingCampaignCode();
			policyEffectiveDate = claimsStatEnquiryAutoResponse.getEffectiveDate();
			policyExpirationDate = claimsStatEnquiryAutoResponse.getExpirationDate();
			String inssuffix = claimsStatEnquiryAutoResponse.getInsuredDetails().getName().getSuffix();
			insNameShort = getData(inssuffix, 3);

			String insName = claimsStatEnquiryAutoResponse.getInsuredDetails().getName().getFirstName()
					+ claimsStatEnquiryAutoResponse.getInsuredDetails().getName().getMiddleName()
					+ claimsStatEnquiryAutoResponse.getInsuredDetails().getName().getLastName()
					+ claimsStatEnquiryAutoResponse.getInsuredDetails().getName().getPrefix();
			insNameFill = getData(insName, 37);
			System.out.println("== insNameFill ==\n"+insNameFill);

			String insuredStreet = claimsStatEnquiryAutoResponse.getInsuredDetails().getInsuredMailingAddres()
					.getAddressLineOne()
					+ claimsStatEnquiryAutoResponse.getInsuredDetails().getInsuredMailingAddres().getAddressLineTwo();
			insStreet = getData(insuredStreet, 40);
			System.out.println("== insStreet ==\n"+insStreet);

			String insuredCity = claimsStatEnquiryAutoResponse.getInsuredDetails().getInsuredMailingAddres().getCity();
			insCity = getData(insuredCity, 33);

			insState = claimsStatEnquiryAutoResponse.getInsuredDetails().getInsuredMailingAddres().getState();
			insState = getData(insState, 2);

			String zip = claimsStatEnquiryAutoResponse.getInsuredDetails().getInsuredMailingAddres().getZipFive();
			zipFirst = getData(zip, 9);

			String writingCompany = claimsStatEnquiryAutoResponse.getCompanyCd();
			writtingCompany = getData(writingCompany, 2);
			stateCode = claimsStatEnquiryAutoResponse.getStateCd();
			majorLine = claimsStatEnquiryAutoResponse.getVehicle().getCoverage().getMajorLineCode();
			statId = claimsStatEnquiryAutoResponse.getVehicle().getCoverage().getStatId();
			statSeg3Info = claimsStatEnquiryAutoResponse.getVehicle().getCoverage().getStatSeg3Info();
		}

		/*System.out.println(problemCode + agencyCampaignNumber + policyEffectiveDate + policyExpirationDate + dedperhig
				+ qatVin + insNameShort + insNameFill + insStreet + insCity + insState + zipFirst + autoNumber
				+ writtingCompany + stateCode + majorLine + statId + statSeg3Info + autoEndTs + detailfill);*/
		// }

		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getWsdlDocumentUrl() {
		return wsdlDocumentUrl;
	}

	public void setWsdlDocumentUrl(String wsdlDocumentUrl) {
		this.wsdlDocumentUrl = wsdlDocumentUrl;
	}

	private String getData(String s1, int expectedLen) {
		String result;
		s1 = s1 == null ? "" : s1;
		int len = s1.length();
		if (len > expectedLen) {
			result = s1.substring(0, expectedLen );
		} else if (len == expectedLen) {
			//System.out.println("s1=" + s1);
			result = s1;
		} else {
			int insblank = expectedLen - len;
			//System.out.println("s1=" + s1);
			//System.out.println("insblank=" + insblank);
			result = s1 + String.format("%-" + insblank + "s", "");
		}
		return result;
	}

	private ClaimsStatEnquiryAutoRequest getRequest() {
		int coverageIndicator = 8;
		String make = "ACURA";
		String makeCode = "ACU";
		String modelYear = "10";
		String vehicleIdentificationNumber = "VIN7654321";
		String accidentDate = "032020";
		String policyNumber = "55100999062";
		String producerCode = "008427";

		Coverage coverage = new Coverage();
		coverage.setCoverageIndicator(coverageIndicator);
		Vehicle vehicle = new Vehicle();
		vehicle.setMake(make);
		vehicle.setMakeCode(makeCode);
		vehicle.setModelYear(modelYear);
		vehicle.setVehicleIdentificationNumber(vehicleIdentificationNumber);
		vehicle.setCoverage(coverage);
		ClaimsStatEnquiryAutoRequest req = new ClaimsStatEnquiryAutoRequest();
		req.setAccidentDate(accidentDate);
		req.setPolicyNumber(policyNumber);
		req.setProducerCode(producerCode);
		req.setVehicle(vehicle);
		return req;
	}

}
