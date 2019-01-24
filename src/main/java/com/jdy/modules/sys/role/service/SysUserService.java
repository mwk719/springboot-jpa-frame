package com.jdy.modules.sys.role.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.common.util.AESUtil;
import com.jdy.common.util.BeanUtil;
import com.jdy.common.util.CodeMsg;
import com.jdy.common.util.JwtUtil;
import com.jdy.common.util.PswdUtil;
import com.jdy.common.util.TokenUtil;
import com.jdy.data.role.decker.SysUserDecker;
import com.jdy.data.role.decker.SysUserRoleDecker;
import com.jdy.data.role.dto.SysUser;
import com.jdy.data.role.dto.SysUserRole;
import com.jdy.modules.sys.role.api.SysUserApi;
import com.jdy.vo.data.TokenUser;
import com.jdy.vo.resp.RespVo;

import cn.hutool.core.util.RandomUtil;

@RestController
@CrossOrigin
public class SysUserService implements SysUserApi {

	@Autowired
	SysUserDecker sysUserDecker;

	@Autowired
	SysUserRoleDecker sysUserRoleDecker;

	@Override
	public RespVo<Object> login(String username, String password, HttpServletRequest request) {

		SysUser su = sysUserDecker.findByUsername(username);
		// 用户师傅存在
		if (su == null) {
			throw new BusinessException(CodeMsg.NOTFINDUSER);
		}
		// 密码是否正确
		if (!PswdUtil.getSysPswd(password, su.getCredentialsSalt()).equals(su.getPassword())) {
			throw new BusinessException(CodeMsg.PSWDERROR);
		}
		// 查询角色
		SysUserRole ur = sysUserRoleDecker.findByAdminId(su.getAdminId());
		// 角色是否存在
		if (ur == null) {
			throw new BusinessException(CodeMsg.NO_ROLE);
		}
		// 加密角色生成token
		TokenUser tu = new TokenUser();
		tu.setAdminId(ur.getAdminId());
		tu.setRoleId(ur.getRoleId());
		tu.setToken(JwtUtil.buildJWT(tu.toString()));
		String token = AESUtil.encryptHex(BeanUtil.beanToString(tu));
		return RespVo.build().success().setBody(token);
	}

	@Override
	public RespVo<Object> getUserList() {
		// throw new BusinessException(CodeMsg.LOGINSUCCESS);
		return RespVo.build().success().setBody("获取系统用户列表");
	}

	@Override
	public void add(String username, String password) {
		SysUser u = new SysUser();
		u.setLoginNum(0);
		u.setState(1);
		u.setUsername(username);
		// sha256加密
		String salt = RandomUtil.simpleUUID();
		u.setSalt(salt);
		sysUserDecker.save(u);
	}

	@Override
	public String logout() {
		System.out.println("退出登陆");
		return null;
	}

}
