package com.hqt.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;



public class UsrInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer ID;
	
	@NotBlank
	private String USERNAME;
	
	@NotBlank
	private String PASSWORD;
	
	@NotBlank
	private String LAST_NAME;
	
	@NotBlank
	private String FIRST_NAME;
	
	@NotBlank
	private String FULL_NAME;
	
	@NotBlank
	private String EMAIL;
	
	private Integer GENDER;
	private Integer IS_LOCKED;
	private Integer IS_DELETED;
	private Date CREATED_DATE;
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

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getFULL_NAME() {
		return FULL_NAME;
	}

	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Integer getGENDER() {
		return GENDER;
	}

	public void setGENDER(Integer gENDER) {
		GENDER = gENDER;
	}

	public Integer getIS_LOCKED() {
		return IS_LOCKED;
	}

	public void setIS_LOCKED(Integer iS_LOCKED) {
		IS_LOCKED = iS_LOCKED;
	}

	public Integer getIS_DELETED() {
		return IS_DELETED;
	}

	public void setIS_DELETED(Integer iS_DELETED) {
		IS_DELETED = iS_DELETED;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
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
