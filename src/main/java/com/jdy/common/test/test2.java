package com.jdy.common.test;

import com.jdy.common.util.AESUtil;
import com.jdy.common.util.BeanUtil;
import com.jdy.vo.data.TokenUser;

public class test2 {

	public static void main(String[] args) {
		String token = "e6a1cd19e82296892b8e3d808e08dcbbf67d822489975e9918fc213e2f28d5e39bcbd4a0f99d5d1645a2ba46941088430514587a2f22631c8effef9ff862505ad970cd94df9267b0634fa31d108fdcc422f63cf1318baa0de23db9a52c1b94a42980e93e6d5f3f915caed27eda081718cd64067454f9e05278208763a0eb5c3f57bfe5406d3d5972062c0e89e99bef3b66e09d9ac583b87ab9cc8313c71499c3ba199c8e8389369540cc6fee34802c74a285541b4a0eeeeae43a995af2defc9ec20f620112455a14a2eeb94e4c5a4bd895c79d80b5727b52da3dd09b2c438035aec5f99e69d565a18a6736c7f8b3a20e268d75bf05fb8aa7cc913ba97b14d488139254bd17d7b6d2f207fd9bd9c484ceacb2b158c28988786666174b4d67ee1d5cacc2fd4cdf271de3e0746037138bb5e4f3cb1fc4044f17f8475fe96ab8c5f9eba541f818b7b95338e79cf54b146c2212020dd1dce750fb140ca45c1d04a5d9";
		String beanstr = AESUtil.decryptStr(token);
		System.out.println(beanstr);
//		TokenUser t = BeanUtil.stringToBean(beanstr, TokenUser.class);
//		System.out.println(t.getPurl()[0]);
		
//		String[] a= {"sysUser/add","sysUser/userList"};
//		String uri="/sys/sysUser/add&a=1";
//		System.out.println(StrUtil.containsAny(uri, a));
		
		
		
	}
}
