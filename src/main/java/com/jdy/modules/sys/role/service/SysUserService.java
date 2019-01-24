package com.jdy.modules.sys.role.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.common.util.CodeMsg;
import com.jdy.common.util.PswdUtil;
import com.jdy.common.util.TokenUtil;
import com.jdy.data.role.decker.SysRolePermissionDecker;
import com.jdy.data.role.decker.SysUserDecker;
import com.jdy.data.role.decker.SysUserRoleDecker;
import com.jdy.data.role.dto.SysUser;
import com.jdy.data.role.dto.SysUserRole;
import com.jdy.modules.sys.role.api.SysUserApi;
import com.jdy.vo.data.TokenUser;
import com.jdy.vo.resp.RespVo;

import cn.hutool.core.util.IdUtil;

@RestController
@CrossOrigin
public class SysUserService implements SysUserApi {

	@Autowired
	SysUserDecker sysUserDecker;

	@Autowired
	SysUserRoleDecker sysUserRoleDecker;

	@Autowired
	SysRolePermissionDecker sysRolePermissionDecker;

	@Override
	public RespVo<Object> login(String username, String password, HttpServletRequest request) {

		SysUser su = sysUserDecker.findByUsername(username);
		// 用户是否存在
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
		// 查询权限列表
		String[] plist = sysRolePermissionDecker.findPermissionUrlByRoleId(ur.getRoleId());

		// 加密角色生成token
		TokenUser tu = new TokenUser();
		tu.setAdminId(ur.getAdminId());
		tu.setRoleId(ur.getRoleId());
		tu.setPurl(plist);
		return RespVo.build().success().setBody(TokenUtil.tokenSetRedis(tu));
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
		String salt = IdUtil.fastSimpleUUID();
		u.setSalt(salt);
		sysUserDecker.save(u);
	}

	@Override
	public RespVo<Object> deleteSysUser(@PathVariable Integer adminId) throws BusinessException {
		return RespVo.build().success().setBody("删除用户成功");
	}

	@Override
	public RespVo<Object> logout(HttpServletRequest request) throws BusinessException {
		// 获取token
		String gas = request.getHeader("gasToken");
		TokenUtil.removeToken(gas);
		return RespVo.build().success();
	}

}
