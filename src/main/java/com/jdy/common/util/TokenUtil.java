package com.jdy.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.common.dto.TokenUser;
import com.jdy.common.dto.TokenUsers;

import cn.hutool.core.util.StrUtil;

/**
 * 对于token的操作
 * 
 * @author 闵渭凯
 *
 *         2019年1月24日
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
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}

		if (!JwtUtil.checkJWT(token))
			throw new BusinessException(CodeMsg.LOGINEXPIRE);
	}

	/**
	 * 根据token获取tokenuser
	 * 
	 * @param token
	 * @return
	 */
	public static TokenUser getTokenUser(String token) {
		if (StrUtil.isBlank(token)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}

		// 验证token是否有效
		vdtToken(token);

		TokenUsers tokenUsers = getTokenUsers();

		for (TokenUser t : tokenUsers.getTokenUser()) {
			// token相同
			if (t.getToken().equals(token)) {
				return t;
			}
		}
		// 尚未登陆
		throw new BusinessException(CodeMsg.NO_LOGIN);
	}

	/**
	 * 获取redis中的tokenuser列表
	 * 
	 * @param token
	 * @return
	 */
	public static TokenUsers getTokenUsers() {

		// 验证token在redis中是否存在
		String redist = RedisUtil.get(TokenUsers.GAS_TOKEN);
		if (StrUtil.isBlank(redist)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}
		TokenUsers tokenUsers = BeanUtil.stringToBean(redist, TokenUsers.class);
		if (StringUtils.isBlank(tokenUsers)) {
			throw new BusinessException(CodeMsg.LOGINEXPIRE);
		}
		return tokenUsers;
	}

	/**
	 * 从redis校验tokenUser
	 * 
	 * @param token
	 *            前端返回的token
	 * @param uri
	 *            前端请求的uri
	 * @throws BusinessException
	 */
	public static void vdtTokenUserAndPermission(String token, String uri) throws BusinessException {
		if (StrUtil.isBlank(token)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}

		TokenUser tokenUser = getTokenUser(token);

		// 权限不存在
		if (tokenUser.getPurl() == null || tokenUser.getPurl().length == 0) {
			throw new BusinessException(CodeMsg.NO_POWER);
		}
		// 权限不匹配
		if (!StrUtil.containsAny(uri, tokenUser.getPurl())) {
			throw new BusinessException(CodeMsg.NO_POWER);
		}
		// 通过
		return;
	}

	/**
	 * 签发token存入redis
	 * 
	 * @param tu
	 *            权限用户
	 * @return 返回给前端的token
	 * @throws BusinessException
	 */
	public static String tokenSetRedis(TokenUser tu) throws BusinessException {
		// 构建jwt
		tu.setToken(JwtUtil.buildJWT(tu.toString()));

		// 获取redis中的用户token
		String tusStr = RedisUtil.get(TokenUsers.GAS_TOKEN);

		// 字符串转token实体
		TokenUsers redistu = BeanUtil.stringToBean(tusStr, TokenUsers.class);
		if (redistu == null) {
			redistu = new TokenUsers();
		}
		if (StringUtils.listIsBlank(redistu.getTokenUser())) {
			List<TokenUser> tulist = new ArrayList<>();
			tulist.add(tu);
			redistu.setTokenUser(tulist);
		} else {
			// 判断redis中admin已存在
			Iterator<TokenUser> it = redistu.getTokenUser().iterator();
			while (it.hasNext()) {
				TokenUser tu1 = it.next();
				// 重新登陆时，移除之前的登陆状态
				if (tu1.getAdminId().equals(tu.getAdminId())) {
					it.remove();
				}
			}
			redistu.getTokenUser().add(tu);
		}
		RedisUtil.set(TokenUsers.GAS_TOKEN, BeanUtil.beanToString(redistu), JwtUtil.DURATION);
		// 加密token
		return tu.getToken();

	}

	/**
	 * 移除用户的登陆
	 * 
	 * @param gasToken
	 */
	public static void removeToken(String token) {
		if (StrUtil.isBlank(token)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}

		// 验证token是否有效
		vdtToken(token);

		TokenUsers tokenUsers = getTokenUsers();

		if (StringUtils.listIsBlank(tokenUsers.getTokenUser())) {
			return;
		} else {

			// 判断redis中admin已存在
			Iterator<TokenUser> it = tokenUsers.getTokenUser().iterator();
			while (it.hasNext()) {
				TokenUser tu1 = it.next();
				// 重新登陆时，移除之前的登陆状态
				if (tu1.getToken().equals(token)) {
					it.remove();
					RedisUtil.set(TokenUsers.GAS_TOKEN, BeanUtil.beanToString(tokenUsers), JwtUtil.DURATION);
					break;
				}
			}
		}

	}

	public static void main(String[] args) {

		TokenUsers tokenUsers = getTokenUsers();
		List<TokenUser> list = tokenUsers.getTokenUser();
		
		list.forEach(user->{
			
			System.out.println(user.toString());
			
		});

	}

}