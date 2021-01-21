package com.bootapp.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date date;
	private String messege;
	private String discription;
	public ExceptionResponse(Date date, String messege, String discription) {
		super();
		this.date = date;
		this.messege = messege;
		this.discription = discription;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
}
