package com.mkyong.processor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class StatCodeServiceConnector {
	private static StatCodeServiceConnector statCodeServiceConnector;

	private StatCodeServiceConnector() {

	}

	public static StatCodeServiceConnector getInstance() {
		if (statCodeServiceConnector == null) {
			synchronized (StatCodeServiceConnector.class) {
				if (statCodeServiceConnector == null) {
					statCodeServiceConnector = new StatCodeServiceConnector();
					System.out.println("statCodeServiceConnector instance created...");
				}
			}
		}
		return statCodeServiceConnector;
	}

	public synchronized String getStatCode(ClaimsStatEnquiryAutoRequest req, String wsdlDocumentUrl, int retryLimit)
			throws IOException {
		// Code to make a webservice HTTP request
		System.out.println("BEGIN  getStatCode");
		boolean isConnectionOk = true;
		String outputString = "";
		int count=0;
		do {
			System.out.println("BEGIN  do");
			String responseString = "";
			String xmlInput = marshal(req);
			HttpURLConnection httpConn = null;
			ByteArrayOutputStream bout = null;
			OutputStream out = null;
			InputStreamReader isr = null;
			BufferedReader in = null;

			// int i;
			// logger.info("== xmlInput ==\n" + xmlInput);
			System.out.println("== xmlInput ==\n" + xmlInput);
			try {
				System.out.println("== wsdlDocumentUrl ==\n" + wsdlDocumentUrl);
				// logger.info("== wsdlDocumentUrl ==\n" + wsdlDocumentUrl);
				URL url = new URL(wsdlDocumentUrl.trim());
				URLConnection connection = url.openConnection();
				httpConn = (HttpURLConnection) connection;
				bout = new ByteArrayOutputStream();

				byte[] buffer = new byte[xmlInput.length()];
				buffer = xmlInput.getBytes();
				bout.write(buffer);
				byte[] b = bout.toByteArray();
				// String SOAPAction = "";
				// Set the appropriate HTTP parameters.
				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
				httpConn.setConnectTimeout(5000);
				httpConn.setReadTimeout(50000);
				// httpConn.setRequestProperty("SOAPAction", SOAPAction);
				httpConn.setRequestMethod("POST");
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				httpConn.setUseCaches(false);
				out = httpConn.getOutputStream();
				// Write the content of the request to the outputstream of the
				// HTTP
				// Connection.
				out.write(b);
				if (out != null) {
					out.flush();
					out.close();
					out = null;
				}
				if (bout != null) {
					bout.flush();
					bout.close();
					bout = null;
				}

				// Ready with sending the request.

				// Read the response.
				// httpConn.connect();
				int status = 0;
				status = httpConn.getResponseCode();
				System.out.println("status code :" + status);
				if (HttpURLConnection.HTTP_OK == status) {
					isr = new InputStreamReader(httpConn.getInputStream());
					in = new BufferedReader(isr);

					// Write the SOAP message response to a String.
					while ((responseString = in.readLine()) != null) {
						outputString = outputString + responseString;
					}
					if (in != null) {
						in.close();
						in = null;
					}
					if (isr != null) {
						isr.close();
						isr = null;
					}
				}
			}

			catch (SocketException e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + " occured 2. so retrying");
				isConnectionOk = false;
				// getStatCode(req, wsdlDocumentUrl);
				// e.printStackTrace();
			} finally {
				if (out != null) {
					out.flush();
					out.close();
				}
				if (bout != null) {
					bout.flush();
					bout.close();
				}
				if (in != null) {
					in.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (httpConn != null) {
					// httpConn.disconnect();
				}
			}
			count++;
			System.out.println("END  do at count ="+count);
		} while (outputString.isEmpty() && count<retryLimit);
		System.out.println(" == outputString == \n" + outputString);
		System.out.println("END  getStatCode");
		return outputString;
	}

	public static Document parseXmlFile(String in, boolean isFileName) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		// dbf.setValidating(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is;
		if (isFileName) {
			is = new InputSource(in);
		} else {
			is = new InputSource(new StringReader(in));
		}
		return db.parse(is);
	}

	public static <T> T unmarshall(Element element, Class<T> clazz) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		T obj = clazz.cast(unmarshaller.unmarshal(element));
		return obj;
	}

	private static String marshal(Object object) {
		JAXBContext jaxbContext;
		StringWriter stringWriter = new StringWriter();
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(object, stringWriter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringWriter.toString();
	}
}
