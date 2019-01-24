package com.jdy.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import com.jdy.common.util.TokenUtil;

/**
 * 请求头token拦截
 * 
 * @author 闵渭凯
 *
 *         2018年8月8日
 */
public class TokenHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 获取token
		String gas = request.getHeader("gasToken");
		//获取请求当时的uri

		if (handler instanceof DefaultServletHttpRequestHandler) {
			return true;
		}
		// 验证token
		TokenUtil.vdtTokenUserAndPermission(gas, request.getRequestURI());
		return true;
	}

}