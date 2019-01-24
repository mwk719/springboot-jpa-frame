package com.jdy.vo.data;

public class TokenUser {

	private Integer adminId;

	private Integer roleId;

	private String token;
	
	

	public TokenUser() {
		super();
	}

	public TokenUser(Integer adminId, Integer roleId, String token) {
		super();
		this.adminId = adminId;
		this.roleId = roleId;
		this.token = token;
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
