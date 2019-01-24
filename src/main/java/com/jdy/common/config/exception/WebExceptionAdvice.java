package com.jdy.common.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdy.vo.resp.RespVo;


/**
 * 访问接口异常统一处理
 * 
 * @author xiong
 *
 */
@RestControllerAdvice
public class WebExceptionAdvice {

	@ExceptionHandler(BusinessException.class)
	public RespVo<Object> errorHandler(BusinessException ex) {
		return RespVo.build().error(ex.getCode());
	}
}
