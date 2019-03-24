package com.jdy.sys.role.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色权限")
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 角色id
	 */
	@ApiModelProperty("角色id")
	@Column(name = "role_id")
	private Integer roleId;

	/**
	 * 权限id
	 */
	@ApiModelProperty("权限id")
	@Column(name = "p_id")
	private Integer pId;

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
	 * 权限id
	 */
	public Integer getPId() {
		return this.pId;
	}

	/**
	 * 权限id
	 */
	public void setPId(Integer pId) {
		this.pId = pId;
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
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "SysRolePermission [roleId=" + roleId + ", pId=" + pId + ", valid=" + valid + "]";
	}

}