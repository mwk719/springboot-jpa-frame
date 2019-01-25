package com.jdy.data.syslog.dto;
import javax.persistence.*;
import java.io.Serializable;
import com.jdy.data.common.dto.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("系统操作日志")
@Entity
@Table(name="sys_operating_log")
public class SysOperatingLog extends BaseEntity implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    @Column(name = "id")
    private Long id ;
    
    
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @Column(name = "role_name")
    private String roleName ;
    
    
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    @Column(name = "username")
    private String username ;
    
    
    /**
     * 操作
     */
    @ApiModelProperty("操作")
    @Column(name = "operation")
    private String operation ;
    
    
    /**
     * 方法名
     */
    @ApiModelProperty("方法名")
    @Column(name = "method")
    private String method ;
    
    
    /**
     * 参数
     */
    @ApiModelProperty("参数")
    @Column(name = "params")
    private String params ;
    
    
    /**
     * ip地址
     */
    @ApiModelProperty("ip地址")
    @Column(name = "ip")
    private String ip ;
    
    
    /**
     * 地区名称
     */
    @ApiModelProperty("地区名称")
    @Column(name = "address")
    private String address ;
    
    
    /**
     * 有效性1-有效，0-无效
     */
    @ApiModelProperty("有效性1-有效，0-无效")
    @Column(name = "valid")
    private Integer valid ;
    
    

     public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	/**
     * 角色名称
     */
    public String getRoleName(){
        return this.roleName;
    }
    
    
    /**
     * 角色名称
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
     /**
     * 用户名称
     */
    public String getUsername(){
        return this.username;
    }
    
    
    /**
     * 用户名称
     */
    public void setUsername(String username){
        this.username = username;
    }
     /**
     * 操作
     */
    public String getOperation(){
        return this.operation;
    }
    
    
    /**
     * 操作
     */
    public void setOperation(String operation){
        this.operation = operation;
    }
     /**
     * 方法名
     */
    public String getMethod(){
        return this.method;
    }
    
    
    /**
     * 方法名
     */
    public void setMethod(String method){
        this.method = method;
    }
     /**
     * 参数
     */
    public String getParams(){
        return this.params;
    }
    
    
    /**
     * 参数
     */
    public void setParams(String params){
        this.params = params;
    }
     /**
     * ip地址
     */
    public String getIp(){
        return this.ip;
    }
    
    
    /**
     * ip地址
     */
    public void setIp(String ip){
        this.ip = ip;
    }
     /**
     * 地区名称
     */
    public String getAddress(){
        return this.address;
    }
    
    
    /**
     * 地区名称
     */
    public void setAddress(String address){
        this.address = address;
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