package com.jdy.vo.resp;

import com.jdy.data.common.dto.Pager;

public class RespVo<T> {

	private RespHeadVo head;

	private Pager pager;

	private T body;

	public Pager getPager() {
		return pager;
	}

	public RespVo<T> setPager(Pager pager) {
		this.pager = pager;
		return this;
	}

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
