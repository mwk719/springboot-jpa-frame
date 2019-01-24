package com.jdy.common.config.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdy.vo.resp.RespVo;


/**
 * 所有异常拦截
 * 
 * @author 闵渭凯
 *
 *         2018年11月4日
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 统一拦截所有未定义异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	RespVo<?> allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		return RespVo.build().success().error(2001);
	}

	/**
	 * 处理所有业务异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	RespVo<?> handleBusinessException(BusinessException e, Exception exception) {
		//exception.printStackTrace();
		return RespVo.build().error(e.getCode());
	}

}