package com.hqt.demo.entities;

import java.io.Serializable;

public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PRODUCT;
	private Integer QUANTILY;
	private Integer PRICE;
	
	public String getPRODUCT() {
		return PRODUCT;
	}
	public void setPRODUCT(String pRODUCT) {
		PRODUCT = pRODUCT;
	}
	public Integer getQUANTILY() {
		return QUANTILY;
	}
	public void setQUANTILY(Integer qUANTILY) {
		QUANTILY = qUANTILY;
	}
	public Integer getPRICE() {
		return PRICE;
	}
	public void setPRICE(Integer pRICE) {
		PRICE = pRICE;
	}

}
