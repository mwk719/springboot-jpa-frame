package com.jdy.common.util;

import com.jdy.data.role.dto.SysUser;

import cn.hutool.json.JSONUtil;

public class BeanUtil {

	/**
	 * 将任意类型转换成字符串
	 * 
	 * @param value
	 * @param <T>
	 * @return
	 */
	public static <T> String beanToString(T value) {
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class) {
			return value + "";
		} else if (clazz == String.class) {
			return (String) value;
		} else if (clazz == long.class || clazz == Long.class) {
			return value + "";
		} else {
			return JSONUtil.toJsonStr(value);
		}
	}

	/**
	 * 把一个字符串转换成bean对象
	 * 
	 * @param str
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		} else if (clazz == String.class) {
			return (T) str;
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else {
			return JSONUtil.toBean(JSONUtil.parse(str).toString(), clazz);
		}
	}

	public static void main(String[] args) {
		SysUser u = new SysUser();
		u.setAdminId(1);
		u.setUsername("admin");
		String ustr = beanToString(u);
		System.out.println(ustr);
		SysUser nu = stringToBean(ustr, SysUser.class);
		System.out.println(nu.getAdminId());

	}

}
