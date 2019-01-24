package com.jdy.common.config.exception;


import com.jdy.common.util.CodeMsg;

import cn.hutool.log.StaticLog;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616181379859058332L;

	private int code;

	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
		this.msg = CodeMsg.getName(code);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BusinessException() {
	}

	public BusinessException(int code) {
		setCode(code);
	}

	public BusinessException(CodeMsg code) {
		this.code = code.getIndex();
		this.msg = code.getName();
		StaticLog.debug("异常信息", this.msg);
	}

}
