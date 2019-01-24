package com.jdy.data.role.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("用户与角色")
@Entity
@Table(name="sys_user_role")
public class SysUserRole implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @Id
    @ApiModelProperty("用户id")
    @Column(name = "admin_id")
    private Integer adminId ;
    
    
    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @Column(name = "role_id")
    private Integer roleId ;
    
    

     /**
     * 用户id
     */
    public Integer getAdminId(){
        return this.adminId;
    }
    
    
    /**
     * 用户id
     */
    public void setAdminId(Integer adminId){
        this.adminId = adminId;
    }
     /**
     * 角色id
     */
    public Integer getRoleId(){
        return this.roleId;
    }
    
    
    /**
     * 角色id
     */
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }
}