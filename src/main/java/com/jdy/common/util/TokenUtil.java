package com.jdy.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.vo.data.TokenUser;
import com.jdy.vo.data.TokenUsers;

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
	 * 解密前端传来的token并验证权限
	 * 
	 * @param token
	 * @throws BusinessException
	 */
	public static void vdtTokenAndPermission(String token, String uri) throws BusinessException {
		if (StrUtil.isBlank(token)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}

		String beanstr = null;
		TokenUser t = null;
		try {
			beanstr = AESUtil.decryptStr(token);
			t = BeanUtil.stringToBean(beanstr, TokenUser.class);
		} catch (Exception e) {
			throw new BusinessException(CodeMsg.AUTHORIZATION_FAILURE);
		}
		// 验证token是否有效
		vdtToken(t.getToken());

		// 权限不存在
		if (t == null || t.getPurl() == null || t.getPurl().length == 0) {
			throw new BusinessException(CodeMsg.NO_POWER);
		}
		// 权限不匹配
		if (!StrUtil.containsAny(uri, t.getPurl())) {
			throw new BusinessException(CodeMsg.NO_POWER);
		}

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

		String beanstr = null;
		TokenUser t = null;
		try {
			beanstr = AESUtil.decryptStr(token);
			t = BeanUtil.stringToBean(beanstr, TokenUser.class);
		} catch (Exception e) {
			throw new BusinessException(CodeMsg.AUTHORIZATION_FAILURE);
		}
		// 验证token是否有效
		vdtToken(t.getToken());

		// 验证token在redis中是否存在
		String redist = RedisUtil.get(new TokenUsers().getGasToken());
		if (StrUtil.isBlank(redist)) {
			throw new BusinessException(CodeMsg.NO_LOGIN);
		}
		TokenUsers tus = BeanUtil.stringToBean(redist, TokenUsers.class);
		if (StringUtils.isBlank(tus)) {
			throw new BusinessException(CodeMsg.LOGINEXPIRE);
		}

		for (TokenUser tt : tus.getTokenUser()) {
			// 同一用户
			if (tt.getAdminId().equals(t.getAdminId())) {
				// 用户一登陆
				if (tt.getToken().equals(t.getToken())) {
					// 权限不存在
					if (t == null || t.getPurl() == null || t.getPurl().length == 0) {
						throw new BusinessException(CodeMsg.NO_POWER);
					}
					// 权限不匹配
					if (!StrUtil.containsAny(uri, t.getPurl())) {
						throw new BusinessException(CodeMsg.NO_POWER);
					}
					// 通过
					return;
				} else {
					// 重新登陆了
					throw new BusinessException(CodeMsg.OYHERLOGIN);
				}
			}
		}
		// 尚未登陆
		throw new BusinessException(CodeMsg.NO_LOGIN);
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

		// 创建权限token
		TokenUsers tus = new TokenUsers();
		String tusStr = RedisUtil.get(tus.getGasToken());

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
		RedisUtil.set(tus.getGasToken(), BeanUtil.beanToString(redistu), JwtUtil.DURATION);
		// 加密token
		return AESUtil.encryptHex(BeanUtil.beanToString(tu));

	}

	/**
	 * 移除用户的登陆
	 * 
	 * @param gasToken
	 */
	public static void removeToken(String gasToken) {
		// 创建权限token
		TokenUsers tus = new TokenUsers();
		String tusStr = RedisUtil.get(tus.getGasToken());

		TokenUsers redistu = BeanUtil.stringToBean(tusStr, TokenUsers.class);

		if (redistu == null) {
			return;
		}
		if (StringUtils.listIsBlank(redistu.getTokenUser())) {
			return;
		} else {
			String beanstr = AESUtil.decryptStr(gasToken);
			TokenUser t = BeanUtil.stringToBean(beanstr, TokenUser.class);

			// 判断redis中admin已存在
			Iterator<TokenUser> it = redistu.getTokenUser().iterator();
			while (it.hasNext()) {
				TokenUser tu1 = it.next();
				// 重新登陆时，移除之前的登陆状态
				if (tu1.getAdminId().equals(t.getAdminId())) {
					it.remove();
					RedisUtil.set(tus.getGasToken(), BeanUtil.beanToString(redistu), JwtUtil.DURATION);
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		// String token =
		// "85b5a5c5f462b6446fd1e30af32d08755129ed006a61c496c1d06aa1c1944d819bcbd4a0f99d5d1645a2ba46941088430514587a2f22631c8effef9ff862505a0473024985424213490ec560dd4bf50cd11b7da8425cc20bc9bffc3d5a295b56a72d5b732f83e6dd5c3a437d1257ef647834287da77c1f69f4b1d93382a40cff29eb93e9f93f6e4f6b27f90a6ddc5388dddafc1e13663aa39522104d5191b1c9372aba6d8c1098d286579af998ed2e6fc8ea83192d7ebed6baba6e7bf4e92c1b1dfc24121c16d61b49bbb2dfa3cf0d5d32a0db5bc311813f5274799320568e902e03b73b8864387e77858ae813da34b11c029296d6eac2219e1ae1fa7e7232eb9b67b5c6b47d2bdee386c2c59d06edcdb631ec0a919d6a8979dd8f3ad405fac91416e61b96b31ec79c01e280862d0c3b17b98e1565e80693354ff0ee9a3e25321a0c228f485ecc9c2e67768afef7b9ae";
		// String uri = "/sys/sysUser/add&a=1";
		// vdtTokenAndPermission(token, uri);

		// TokenUser tu = new TokenUser();
		// tu.setAdminId(1);
		// tu.setRoleId(1);
		// tu.setPurl(null);
		//
		// System.out.println(tokenSetRedis(tu));
		// RedisUtil.set(new TokenUsers().getGasToken(), "", 1);
		String token = "e6a1cd19e82296892b8e3d808e08dcbbf67d822489975e9918fc213e2f28d5e39bcbd4a0f99d5d1645a2ba46941088430514587a2f22631c8effef9ff862505ad970cd94df9267b0634fa31d108fdcc422f63cf1318baa0de23db9a52c1b94a42980e93e6d5f3f915caed27eda081718cd64067454f9e05278208763a0eb5c3f57bfe5406d3d5972062c0e89e99bef3b66e09d9ac583b87ab9cc8313c71499c3ba199c8e8389369540cc6fee34802c74a285541b4a0eeeeae43a995af2defc9ec20f620112455a14a2eeb94e4c5a4bd895c79d80b5727b52da3dd09b2c438035aec5f99e69d565a18a6736c7f8b3a20e268d75bf05fb8aa7cc913ba97b14d488139254bd17d7b6d2f207fd9bd9c484ceacb2b158c28988786666174b4d67ee1d5cacc2fd4cdf271de3e0746037138bb5e4f3cb1fc4044f17f8475fe96ab8c5f9eba541f818b7b95338e79cf54b146c2212020dd1dce750fb140ca45c1d04a5d9";
		removeToken(token);
		System.out.println(RedisUtil.get(new TokenUsers().getGasToken()));

	}

}