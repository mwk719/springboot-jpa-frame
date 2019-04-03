package com.jdy.common.dto;

import java.util.List;

public class TokenUsers {

	/**
	 * 存入redis的key
	 */
	public final static String GAS_TOKEN = "GAS_TOKEN_V2.0";

	/**
	 * token列表
	 */
	private List<TokenUser> tokenUser;

	public List<TokenUser> getTokenUser() {
		return tokenUser;
	}

	public void setTokenUser(List<TokenUser> tokenUser) {
		this.tokenUser = tokenUser;
	}

}
