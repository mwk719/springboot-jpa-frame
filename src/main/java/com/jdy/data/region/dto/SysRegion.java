package com.jdy.data.region.dto;
import javax.persistence.*;
import java.io.Serializable;
import com.jdy.data.common.dto.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("地区管理")
@Entity
@Table(name="sys_region")
public class SysRegion extends BaseEntity implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    @Column(name = "region_id")
    private Integer regionId ;
    
    
    /**
     * 地区名称
     */
    @ApiModelProperty("地区名称")
    @Column(name = "name")
    private String name ;
    
    
    /**
     * 有效性1-有效，0-无效
     */
    @ApiModelProperty("有效性1-有效，0-无效")
    @Column(name = "valid")
    private Integer valid ;
    
    

     /**
     * 
     */
    public Integer getRegionId(){
        return this.regionId;
    }
    
    
    /**
     * 
     */
    public void setRegionId(Integer regionId){
        this.regionId = regionId;
    }
     /**
     * 地区名称
     */
    public String getName(){
        return this.name;
    }
    
    
    /**
     * 地区名称
     */
    public void setName(String name){
        this.name = name;
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