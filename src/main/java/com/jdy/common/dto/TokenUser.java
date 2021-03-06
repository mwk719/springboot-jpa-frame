package com.jdy.common.dto;

public class TokenUser {

	private Integer adminId;

	private Integer roleId;

	private String token;
	
	private String[] purl;
	
	

	public TokenUser() {
		super();
	}

	public TokenUser(Integer adminId, Integer roleId, String token) {
		super();
		this.adminId = adminId;
		this.roleId = roleId;
		this.token = token;
	}

	
	


	public String[] getPurl() {
		return purl;
	}

	public void setPurl(String[] purl) {
		this.purl = purl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "TokenUser [adminId=" + adminId + ", roleId=" + roleId + ", token=" + token + "]";
	}
	
	

}
