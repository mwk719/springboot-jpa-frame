package com.jdy.sys.log.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("系统操作日志")
public class RespSysOperatingLogVo {
	/**
	 * 
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	@ApiModelProperty("角色名称")
	private String roleName;

	/**
	 * 用户名称
	 */
	@ApiModelProperty("用户名称")
	private String username;

	/**
	 * 操作
	 */
	@ApiModelProperty("操作")
	private String operation;

	/**
	 * 方法名
	 */
	@ApiModelProperty("方法名")
	private String method;

	/**
	 * 参数
	 */
	@ApiModelProperty("参数")
	private String params;

	/**
	 * ip地址
	 */
	@ApiModelProperty("ip地址")
	private String ip;

	/**
	 * 地区名称
	 */
	@ApiModelProperty("地区名称")
	private String address;
	
	@ApiModelProperty("操作时间")
	private String CreateTime;
	
	

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 角色名称
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 用户名称
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 用户名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 操作
	 */
	public String getOperation() {
		return this.operation;
	}

	/**
	 * 操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * 方法名
	 */
	public String getMethod() {
		return this.method;
	}

	/**
	 * 方法名
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 参数
	 */
	public String getParams() {
		return this.params;
	}

	/**
	 * 参数
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * ip地址
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * ip地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 地区名称
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 地区名称
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}