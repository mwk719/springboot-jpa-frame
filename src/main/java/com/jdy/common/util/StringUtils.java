package com.jdy.common.util;

import java.util.List;

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

	public static boolean listIsBlank(List list) {

		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	public static boolean listIsNotBlank(List list) {

		if (list != null && list.size() > 0)
			return true;
		return false;
	}

	/**
	 * 数组转string ，分割
	 * 
	 * @param str
	 * @return
	 */
	public static String array2Str(String[] str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if (i == 0) {
				sb.append(str[i]);
			} else {
				sb.append("," + str[i]);
			}
		}
		return sb.toString();

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
	 * 根据安装工单类型返回工单状态文字
	 * 
	 * @param workType
	 *            2.装表、3.勘测通气、4.通气、5.装表通气
	 * @return
	 */
	public static String workTypeStr(Integer workType) {

		String workTypeStr = "装表";
		switch (workType) {
		case 2:
			workTypeStr = "装表";
			break;
		case 4:
			workTypeStr = "通气";
			break;
		case 5:
			workTypeStr = "装表通气";
			break;
		}
		return workTypeStr;

	}

	/**
	 * 根据预约工单类型返回工单状态文字
	 * 
	 * @param workType
	 *            2.装表、3.通气
	 * @return
	 */
	public static String bespeakTypeStr(Integer bespeakType) {

		String bespeakTypeStr = "装表";
		switch (bespeakType) {
		case 2:
			bespeakTypeStr = "装表";
			break;
		case 3:
			bespeakTypeStr = "通气";
			break;
		}
		return bespeakTypeStr;

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

	/**
	 * 根据地址名称判断用户所属地
	 * 
	 * @param address
	 * @return
	 */
	public static Integer getDependency(String address) {
		if (StrUtil.containsAny(address, "阿荣旗"))
			return 1;
		if (StrUtil.containsAny(address, "牙克石"))
			return 2;
		return 1;
	}

	/**
	 * 根据地址id判断用户所属地
	 * 
	 * @param address
	 * @return
	 */
	public static String getAddressByDependency(Integer dependency) {

		switch (dependency) {
		case 1:
			return "阿荣旗";
		case 2:
			return "牙克石";
		}
		return "阿荣旗";
	}

	public static void main(String[] args) {
		System.out.println(getDependency("克阿克荣旗牙克石"));
	}

}
