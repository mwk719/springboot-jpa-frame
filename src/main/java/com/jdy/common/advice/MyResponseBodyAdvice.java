package com.jdy.common.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.jdy.vo.resp.RespVo;


@SuppressWarnings("rawtypes")
@RestControllerAdvice(basePackages = "com.jdy")
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		if (body == null) {
			return RespVo.build().success();
		}

		if (body instanceof RespVo) {

			return body;
		}
		return RespVo.build().success().setBody(body);
	}

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}
}
