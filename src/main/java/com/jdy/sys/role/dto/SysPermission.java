package com.jdy.sys.role.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdy.common.dto.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("权限信息")
@Entity
@Table(name="sys_permission")
public class SysPermission extends BaseEntity implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    @Column(name = "p_id")
    private Integer pId ;
    
    
    /**
     * 名称.
     */
    @ApiModelProperty("名称.")
    @Column(name = "name")
    private String name ;
    
    
    /**
     * 资源路径.
     */
    @ApiModelProperty("资源路径.")
    @Column(name = "url")
    private String url ;
    
    
    /**
     * 父编号
     */
    @ApiModelProperty("父编号")
    @Column(name = "parent_id")
    private Integer parentId ;
    
    
    /**
     * 有效性1-有效，0-无效
     */
    @ApiModelProperty("有效性1-有效，0-无效")
    @Column(name = "valid")
    private Integer valid ;
    

     public Integer getpId() {
		return pId;
	}


	public void setpId(Integer pId) {
		this.pId = pId;
	}



	/**
     * 
     */
    public Integer getPId(){
        return this.pId;
    }
    
    
    /**
     * 
     */
    public void setPId(Integer pId){
        this.pId = pId;
    }
     /**
     * 名称.
     */
    public String getName(){
        return this.name;
    }
    
    
    /**
     * 名称.
     */
    public void setName(String name){
        this.name = name;
    }
     /**
     * 资源路径.
     */
    public String getUrl(){
        return this.url;
    }
    
    
    /**
     * 资源路径.
     */
    public void setUrl(String url){
        this.url = url;
    }
     /**
     * 父编号
     */
    public Integer getParentId(){
        return this.parentId;
    }
    
    
    /**
     * 父编号
     */
    public void setParentId(Integer parentId){
        this.parentId = parentId;
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
}