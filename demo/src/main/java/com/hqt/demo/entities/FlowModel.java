package com.hqt.demo.entities;

import java.io.Serializable;

public class FlowModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsrInfo usrInfo;
	
	private Bill bill;

	public UsrInfo getUsrInfo() {
		return usrInfo;
	}

	public void setUsrInfo(UsrInfo usrInfo) {
		this.usrInfo = usrInfo;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	

}
