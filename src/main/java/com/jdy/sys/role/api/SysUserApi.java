package com.jdy.sys.role.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.common.vo.resp.RespVo;
import com.jdy.sys.role.vo.req.ReqSysUserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "系统用户" })
@RequestMapping("sys/sysUser")
public interface SysUserApi {

	@ApiOperation("系统用户登陆")
	@PostMapping("login")
	RespVo<Object> login(@RequestBody ReqSysUserVo sysUser, HttpServletRequest request) throws BusinessException;

	@ApiOperation("获取系统用户列表")
	@GetMapping("list")
	RespVo<Object> getUserList() throws BusinessException;

	@ApiOperation("新增系统用户列表")
	@PostMapping("add")
	void add(@RequestBody ReqSysUserVo sysUser) throws BusinessException;

	@ApiOperation("删除系统用户")
	@DeleteMapping("delete/{adminId}")
	RespVo<Object> deleteSysUser(@PathVariable Integer adminId) throws BusinessException;

	@ApiOperation("退出系统")
	@GetMapping("logout")
	RespVo<Object> logout(HttpServletRequest request) throws BusinessException;

}
