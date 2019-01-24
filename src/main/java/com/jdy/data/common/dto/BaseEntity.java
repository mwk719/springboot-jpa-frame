package com.jdy.data.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * 创建时间
     */

    private Date createTime;
    
    
    /**
     * 更新时间
     */
	
    private Date updateTime;

	


	public Date getCreateTime() {
		return createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}


	@Column
	@CreatedDate
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column
	@LastModifiedDate
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
