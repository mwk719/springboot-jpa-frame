package com.jdy.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;


/**
 * redis操作
 * @author 闵渭凯
 *
 * 2018年7月19日
 */
public final class RedisUtil {

	private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	// Redis服务器IP
	final private static String ADDR = "120.79.207.240";
	final private static String pswd = "mwk666";
	
//	final private static String ADDR = "1.180.170.250";
//	final private static String pswd = "hainuoranqi";
	// Redis的端口号
	final private static int PORT = 6379;
	//
	
	public static Jedis getJedis() {
		Jedis jedis = new Jedis(ADDR, PORT);
		jedis.auth(pswd);
		// 查看服务是否运行
		try {
			logger.info("Redis服务正在运行: " + jedis.ping());
		} catch (Exception e) {
			System.out.println("Redis没有启动");
		}
		return jedis;

	}

	/**
	 * 设置缓存
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param cacheSeconds
	 *            超时时间，0为不超时
	 * @return
	 */
	public static String set(String key, String value, int cacheSeconds) {
		String result = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			result = jedis.set(key, value);
			if (cacheSeconds != 0) {
				jedis.expire(key, cacheSeconds);
			}
		} catch (Exception e) {
			logger.warn("set {} = {}", key, value, e);
			return result;
		} finally {
			jedis.close();
		}
		return result;

	}
	
	/**
	 * 获取redis
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String result = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.warn("set {} = {}", key, result, e);
			return result;
		} finally {
			jedis.close();
		}
		return result;

	}
	
	public static void main(String[] args) {
		System.out.println(get("GAS_Token_c4cfb04994f5434d99586cb309d3814f"));
	}

}