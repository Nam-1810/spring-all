package com.hqt.demo.entities;

import java.util.Date;

public class UsrToken {
	private Integer ID;
	private String USERNAME;
	private String TOKEN;
	private String EXPIRED_DATE;
	private String CREATED_DATE;
	private String CREATE_USER;
	private String UPDATE_USER;
	private Date UPDATE_DATE;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getTOKEN() {
		return TOKEN;
	}
	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}
	public String getEXPIRED_DATE() {
		return EXPIRED_DATE;
	}
	public void setEXPIRED_DATE(String eXPIRED_DATE) {
		EXPIRED_DATE = eXPIRED_DATE;
	}
	public String getCREATED_DATE() {
		return CREATED_DATE;
	}
	public void setCREATED_DATE(String cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}
	public String getCREATE_USER() {
		return CREATE_USER;
	}
	public void setCREATE_USER(String cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}
	public String getUPDATE_USER() {
		return UPDATE_USER;
	}
	public void setUPDATE_USER(String uPDATE_USER) {
		UPDATE_USER = uPDATE_USER;
	}
	public Date getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(Date uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	
	
}


