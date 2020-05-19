package com.example.Customers.ErrorHandler;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {

	private Date timeStamp;
	private String message;
	private List<String> details;
	
	public ErrorResponse() {
	
	}
	
	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public List<String> getDetails() {
		return details;
	}
	
}
