package com.mkyong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkyong.processor.EncriptionDecriptionUtil;

public class EncDecUtil {
	public static void main(String[] args) {
		//encodeDecode();
		dateFormat();
		/*try{
			testException();
		}catch(Exception e){
			System.out.println("Exception message="+e.getMessage());
		}*/
		Map<String,String> mandatoryFields = new HashMap<String,String>();
			    mandatoryFields.put("UUID", ""+7687789);
			    mandatoryFields.put("id", "" + 6765);
			    mandatoryFields.put("caseId", null);
		mapEmptyFieldCheck(mandatoryFields);
		
	}
	
	private static List<String> mapEmptyFieldCheck(Map<String,String> fields){
		List<String> emptyFields = new ArrayList<String>();
		System.out.println("fields.toString()"+fields.toString());
		fields.values().removeIf(val->!isStringEmpty(val));
		emptyFields.addAll(fields.keySet());
		System.out.println("emptyFields.toString()"+emptyFields.toString());
		return emptyFields;
	}
	
	private static void testException() throws Exception{
		throw new Exception("Throwing sample Exception");
	}
	
	private static void dateFormat(){
		String date = "20200103";
		try {
			Date input = new SimpleDateFormat("yyyyMMdd").parse(date);
			System.out.println("input date="+new SimpleDateFormat("MMddyy").format(input));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(""+new SimpleDateFormat("MMddyy").format(new Date()));
	}
	
	private static void encodeDecode(){

		String userName = "user";
		String encPassword = "R1cnhe792r42rrahg==";
		String valueToEncrypt = "$PM2386trf3r49^ti^4Ttggf238t632874Tt";
		String encPass = EncriptionDecriptionUtil.encrypt(valueToEncrypt);
		System.out.println("encPass = "+encPass);
		
		String authFile = "C:/temp/data/Key.txt";
		String decriptedPassword = EncriptionDecriptionUtil.getDecryptedPassword(authFile, encPassword);
		System.out.println("decriptedPassword = " + decriptedPassword);
		if (decriptedPassword != null) {
			String authKey = EncriptionDecriptionUtil.getEncodedAuthKey(userName, decriptedPassword);
			System.out.println("authKey = " + authKey);
		}
	
	}
	
	public static boolean isStringEmpty(String s)  {
		boolean isEmpty = true;
	    if (s != null && !s.isEmpty()) {
	      isEmpty = false;
	    }
	    return isEmpty;
	  }
}
