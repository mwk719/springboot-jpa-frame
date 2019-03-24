package com.jdy.common.vo.resp;

import com.jdy.common.util.CodeMsg;

import io.swagger.annotations.ApiModelProperty;

public class RespHeadVo {

	/**
	 * 0失败/1成功
	 */
	@ApiModelProperty(value = "返回状态码（0失败/1成功）", example = "0")
	private Integer status = 1;

	/**
	 * 失败状态码
	 */
	@ApiModelProperty(value = "失败状态码", example = "100")
	private Integer errorCode;
	/**
	 * 失败消息
	 */
	@ApiModelProperty(value = "失败信息", example = "请求参数错误")
	private String errorMsg;

	public static RespHeadVo build() {
		return new RespHeadVo();
	}

	public RespHeadVo success() {
		this.status = 1;
		this.errorCode = null;
		this.errorMsg = null;
		return this;
	}
	
	public RespHeadVo error(int errorCode) {
		this.status = 0;
		this.errorCode = errorCode;
		this.errorMsg = CodeMsg.getName(errorCode);
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
