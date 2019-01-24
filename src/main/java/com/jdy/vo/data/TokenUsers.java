package com.jdy.vo.data;

import java.util.List;

public class TokenUsers {
	
	/**
	 * 存入redis的key
	 */
	private String gasToken="gasToken";
	
	private List<TokenUser> tokenUser;

	public String getGasToken() {
		return gasToken;
	}

	public void setGasToken(String gasToken) {
		this.gasToken = gasToken;
	}

	public List<TokenUser> getTokenUser() {
		return tokenUser;
	}

	public void setTokenUser(List<TokenUser> tokenUser) {
		this.tokenUser = tokenUser;
	}
	
	

}
