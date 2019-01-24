package com.jdy.common.util;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * 密码
 * 
 * @author 闵渭凯
 *
 *         2019年1月22日
 */
public class PswdUtil {

	/**
	 * 系统密码
	 * 
	 * @param password
	 * @param solt
	 * @return
	 */
	public static String getSysPswd(String password, String solt) {
		return DigestUtil.md5Hex(password + solt);
	}

}
