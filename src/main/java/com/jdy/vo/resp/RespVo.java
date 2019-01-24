package com.jdy.vo.resp;

public class RespVo<T> {

	private RespHeadVo head;


	private T body;

	public static RespVo<Object> build() {
		return new RespVo<Object>();
	}

	public RespVo<T> success() {
		this.setHead(RespHeadVo.build().success());
		return this;
	}

	public RespVo<T> error(int errorCode) {
		this.setHead(RespHeadVo.build().error(errorCode));
		return this;
	}

	public RespHeadVo getHead() {
		return head;
	}

	public void setHead(RespHeadVo head) {
		this.head = head;
	}


	public RespVo<T> setBody(T body) {
		this.body = body;
		return this;
	}

	public T getBody() {
		return body;
	}
	
	


}
