package com.jdy.common.util;

import com.jdy.common.config.exception.BusinessException;

import cn.hutool.core.util.StrUtil;

/**
 * 对于token的操作
 * 
 * @author 闵渭凯 2018年7月9日
 */
public class TokenUtil {

	/**
	 * token校验
	 * 
	 * @param token
	 * @return
	 */
	public static void vdtToken(String token) throws BusinessException {
		if (StrUtil.isBlank(token)) {
			throw new BusinessException(CodeMsg.LOGINEXPIRE);
		}

		if (!JwtUtil.checkJWT(token))
			throw new BusinessException(CodeMsg.LOGINEXPIRE);
	}

	public static void createToken(String jwtToken) throws BusinessException {
	}

}