package com.jdy.modules.sys.role.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.vo.resp.RespVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "系统用户" })
@RequestMapping("sys/sysUser")
public interface SysUserApi {

	@ApiOperation("系统用户登陆")
	@PostMapping("login")
	RespVo<Object> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request)
			throws BusinessException;

	@ApiOperation("获取系统用户列表")
	@GetMapping("userList")
	RespVo<Object> getUserList() throws BusinessException;

	@ApiOperation("新增系统用户列表")
	@PostMapping("add")
	void add(@RequestParam String username, @RequestParam String password) throws BusinessException;

	@ApiOperation("删除系统用户")
	@DeleteMapping("deleteSysUser/{adminId}")
	RespVo<Object> deleteSysUser(@PathVariable Integer adminId) throws BusinessException;
	
	@ApiOperation("退出系统")
	@GetMapping("logout")
	RespVo<Object> logout(HttpServletRequest request) throws BusinessException;

}
