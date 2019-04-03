package com.jdy.sys.role.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("系统用户")
public class ReqSysUserVo {

	/**
	 * 用户名称
	 */
	@ApiModelProperty("用户名称")
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}