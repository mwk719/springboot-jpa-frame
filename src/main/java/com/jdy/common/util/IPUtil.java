package com.jdy.common.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

/**
 * 对于IP的操作
 * 
 * @author 闵渭凯
 *
 *         2019年1月25日
 */
public class IPUtil {
	public static void main(String[] args) {

		System.out.println(getAddressByIp("183.62.35.197"));

	}

	/**
	 * 根据IP获取地址
	 * 
	 * @param ip
	 * @return
	 */
	public static String getAddressByIp(String ip) {
		String path = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
		StringBuilder sb = new StringBuilder();
		try {
			String str = HttpUtil.get(path, 1000 * 10);
			Object data = JSONUtil.parse(str).getByPath("data");
			sb.append(JSONUtil.parse(data).getByPath("country"));
			sb.append(JSONUtil.parse(data).getByPath("region"));
			sb.append(JSONUtil.parse(data).getByPath("city"));
			return sb.toString();
		} catch (Exception e) {
			return null;
		}

	}
}
