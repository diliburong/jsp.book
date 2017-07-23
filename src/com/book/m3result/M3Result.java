package com.book.m3result;


import org.json.JSONException;
import org.json.JSONObject; 

public class M3Result {

	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public JSONObject setM3Result(){
		JSONObject m3Result=new JSONObject();
		try {
			
			
			m3Result.put("status", this.getStatus());
			m3Result.put("message", this.getMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m3Result;
	}
	
	
}
