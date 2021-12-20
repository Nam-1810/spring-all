package com.hqt.demo.entities;

public class AuthenticatioanResponse {
	private final String jwt;
	
	public AuthenticatioanResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	

}
