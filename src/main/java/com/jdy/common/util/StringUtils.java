package com.jdy.common.util;

import java.util.Collection;

import com.jdy.common.config.exception.BusinessException;

import cn.hutool.core.util.StrUtil;

/**
 * String工具 主要对 StringUtils 的一些方法进行重写,达到更方便的使用
 *
 */
public class StringUtils {

	/**
	 * 一次性判断多个或单个对象为空。
	 * 
	 * @param objects
	 * @author zhou-baicheng
	 * @return 只要有一个元素为Blank，则返回true
	 */
	public static boolean isBlank(Object... objects) {
		Boolean result = false;
		for (Object object : objects) {
			if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 一次性判断多个或单个对象不为空。
	 * 
	 * @param objects
	 * @author zhou-baicheng
	 * @return 只要有一个元素不为Blank，则返回true
	 */
	public static boolean isNotBlank(Object... objects) {
		return !isBlank(objects);
	}

	public static boolean isBlank(String... objects) {
		Object[] object = objects;
		return isBlank(object);
	}

	public static boolean isNotBlank(String... objects) {
		Object[] object = objects;
		return !isBlank(object);
	}

	public static boolean isBlank(String str) {
		Object object = str;
		return isBlank(object);
	}

	public static boolean isNotBlank(String str) {
		Object object = str;
		return !isBlank(object);
	}

	@SuppressWarnings("rawtypes")
	public static boolean listIsBlank(Collection collection) {

		if (collection == null || collection.size() == 0)
			return true;
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static boolean listIsNotBlank(Collection collection) {

		if (collection != null && collection.size() > 0)
			return true;
		return false;
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param object
	 * @return
	 */
	public static boolean ArryIsBlank(Object[] object) {
		if (object == null || object.length == 0)
			return true;
		return false;
	}

	public static boolean ArryIsNotBlank(Object[] object) {
		if (object != null && object.length > 0)
			return true;
		return false;
	}

	/**
	 * 参数不能为空校验
	 * 
	 * @param objects
	 * @throws BusinessException
	 */
	public static void throwCheckEmpty(Object... objects) throws BusinessException {
		if (isBlank(objects))
			throw new BusinessException(CodeMsg.NOTEMPTY);

	}

	/**
	 * 数组转str
	 * 
	 * @param str
	 * @return
	 */
	public static String array2str(Object[] str) {

		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < str.length; i++) {
			if (i > 0)
				sb.append(",");
			sb.append(str[i]);
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 字符串数组转数组
	 * 
	 * @param arryStr
	 * @return
	 */
	public static String[] arryStr2arr(String arryStr) {
		if (arryStr == null || arryStr.length() == 0)
			return null;

		String b = StrUtil.removeAll(arryStr, "[").replace("]", "");
		String[] g = b.split(",");
		return g;

	}

	public static void main(String[] args) {

		String a = "";
		int b = 1;
		Integer c = 3;

		throwCheckEmpty(a, b, c);

	}

}
