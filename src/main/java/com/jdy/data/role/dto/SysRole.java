package com.jdy.data.role.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdy.data.common.dto.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色信息")
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	/**
	 * 角色id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("角色id")
	@Column(name = "role_id")
	private Integer roleId;

	/**
	 * 角色标识程序中判断使用,如"admin",这个是唯一的:
	 */
	@ApiModelProperty("角色标识程序中判断使用,如admin,这个是唯一的:")
	@Column(name = "role")
	private String role;

	/**
	 * 角色描述,UI界面显示使用
	 */
	@ApiModelProperty("角色描述,UI界面显示使用")
	@Column(name = "description")
	private String description;

	/**
	 * 
	 */
	@ApiModelProperty("")
	@Column(name = "department_id")
	private Integer departmentId;

	/**
	 * 有效性1-有效，0-无效
	 */
	@ApiModelProperty("有效性1-有效，0-无效")
	@Column(name = "valid")
	private Integer valid;

	
	


	/**
	 * 角色id
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 * 角色id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 角色标识程序中判断使用,如"admin",这个是唯一的:
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * 角色标识程序中判断使用,如"admin",这个是唯一的:
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 角色描述,UI界面显示使用
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 角色描述,UI界面显示使用
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	* 
	*/
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	/**
	 * 
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 有效性1-有效，0-无效
	 */
	public Integer getValid() {
		return this.valid;
	}

	/**
	 * 有效性1-有效，0-无效
	 */
	public void setValid(Integer valid) {
		this.valid = valid;
	}
}