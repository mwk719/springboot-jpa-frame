package com.jdy.data.role.dto;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jdy.data.common.dto.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("系统用户")
@Entity
@Table(name="sys_user")
public class SysUser extends BaseEntity implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    /**
     * 系统用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("系统用户id")
    @Column(name = "admin_id")
    private Integer adminId ;
    
    
    /**
     * 账号
     */
    @ApiModelProperty("账号")
    @Column(name = "username")
    private String username ;
    
    
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    @ApiModelProperty("名称（昵称或者真实姓名，不同系统不同定义）")
    @Column(name = "name")
    private String name ;
    
    
    /**
     * 密码;
     */
    @ApiModelProperty("密码;")
    @Column(name = "password")
    private String password ;
    
    
    /**
     * 加密密码的盐
     */
    @ApiModelProperty("加密密码的盐")
    @Column(name = "salt")
    private String salt ;
    
    
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    @ApiModelProperty("用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.")
    @Column(name = "state")
    private Integer state ;
    
    
    /**
     * 登录次数
     */
    @ApiModelProperty("登录次数")
    @Column(name = "login_num")
    private Integer loginNum ;
    
    
    /**
     * 地区id
     */
    @ApiModelProperty("地区id")
    @Column(name = "region_id")
    private Integer regionId ;
    
    
    /**
     * 有效性1-有效，0-无效
     */
    @ApiModelProperty("有效性1-有效，0-无效")
    @Column(name = "valid")
    private Integer valid ;


	/**
     * 系统用户id
     */
    public Integer getAdminId(){
        return this.adminId;
    }
    
    
    /**
     * 系统用户id
     */
    public void setAdminId(Integer adminId){
        this.adminId = adminId;
    }
     /**
     * 账号
     */
    public String getUsername(){
        return this.username;
    }
    
    
    /**
     * 账号
     */
    public void setUsername(String username){
        this.username = username;
    }
     /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    public String getName(){
        return this.name;
    }
    
    
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    public void setName(String name){
        this.name = name;
    }
     /**
     * 密码;
     */
    public String getPassword(){
        return this.password;
    }
    
    
    /**
     * 密码;
     */
    public void setPassword(String password){
        this.password = password;
    }
     /**
     * 加密密码的盐
     */
    public String getSalt(){
        return this.salt;
    }
    
    
    /**
     * 加密密码的盐
     */
    public void setSalt(String salt){
        this.salt = salt;
    }
     /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    public Integer getState(){
        return this.state;
    }
    
    
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    public void setState(Integer state){
        this.state = state;
    }
     /**
     * 登录次数
     */
    public Integer getLoginNum(){
        return this.loginNum;
    }
    
    
    /**
     * 登录次数
     */
    public void setLoginNum(Integer loginNum){
        this.loginNum = loginNum;
    }
     /**
     * 地区id
     */
    public Integer getRegionId(){
        return this.regionId;
    }
    
    
    /**
     * 地区id
     */
    public void setRegionId(Integer regionId){
        this.regionId = regionId;
    }
     /**
     * 有效性1-有效，0-无效
     */
    public Integer getValid(){
        return this.valid;
    }
    
    
    /**
     * 有效性1-有效，0-无效
     */
    public void setValid(Integer valid){
        this.valid = valid;
    }
    
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}