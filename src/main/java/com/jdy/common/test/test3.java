package com.jdy.common.test;

import com.jdy.common.util.JwtUtil;

public class test3 {

	public static void main(String[] args) {
		String sub = "管理员";
		String jti = "11111";

		String token1 = JwtUtil.buildJWT(sub, jti, 60 * 60);
		String token2 = JwtUtil.buildJWT(sub, jti, 60 * 60);

		
		System.out.println(JwtUtil.checkJWT(token1, sub));

	}
}
