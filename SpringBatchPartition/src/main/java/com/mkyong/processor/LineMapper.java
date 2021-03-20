package com.mkyong.processor;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mkyong.User;

public class LineMapper implements ItemReader<User> {

	private String inputLine;
	private int exeCtxThreadID;
	private int isRead;

	public String getInputLine() {
		return inputLine;
	}

	public void setInputLine(String inputLine) {
		this.inputLine = inputLine;
	}

	public int getExeCtxThreadID() {
		return exeCtxThreadID;
	}

	public void setExeCtxThreadID(int exeCtxThreadID) {
		this.exeCtxThreadID = exeCtxThreadID;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		User user = null;
		/*if (isRead == 0) {
			user = new User();
			String[] s = inputLine.split(",");
			System.out.println("THREAD = " + exeCtxThreadID + "Reading : " + inputLine);
			user.setId(Integer.valueOf(s[0]));
			user.setUsername(s[1]);
			user.setPassword(s[2]);
			user.setAge(Integer.valueOf(s[3]));
			isRead = 1;
		} else{
			System.out.println("ALREADY READ - THREAD = " + exeCtxThreadID + "Reading : " + inputLine);
		}
		return user;*/
	
		if(inputLine != null){
			user = new User();
			String[] s = inputLine.split(",");
			System.out.println("THREAD = " + exeCtxThreadID + "Reading : " + inputLine);
			user.setId(Integer.valueOf(s[0]));
			user.setUsername(s[1]);
			user.setPassword(s[2]);
			user.setAge(Integer.valueOf(s[3]));
			inputLine = null;
		}else{
			System.out.println("ALREADY READ - THREAD = " + exeCtxThreadID + "Reading : " + inputLine);
		}
		return user;
	}
}
