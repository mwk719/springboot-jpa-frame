package com.jdy.common.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class AESUtil {

	static String key = "mwk^_^666*07gj-=";

	/**
	 * 加密为16进制表示
	 * 
	 * @param content
	 * @return
	 */
	public static String encryptHex(String content) {
		// 构建
		SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
		//
		return aes.encryptHex(content);
	}

	/**
	 * 解密为字符串
	 * 
	 * @param encryptHex
	 * @return
	 */
	public static String decryptStr(String encryptHex) {
		// 构建
		SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
		//
		return aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
	}

	public static void main(String[] args) {
		String content = "java";
		String encryptHex = "83daafac9192f8057213e2642ee9f166";
		System.out.println(encryptHex(content));
		System.out.println(decryptStr(encryptHex));

	}

}
