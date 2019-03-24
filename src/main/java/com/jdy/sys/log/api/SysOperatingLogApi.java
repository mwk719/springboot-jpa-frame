package com.jdy.sys.log.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdy.common.config.exception.BusinessException;
import com.jdy.common.dto.Pager;
import com.jdy.common.vo.resp.RespVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "系统操作日志" })
@RequestMapping("sys/log")
public interface SysOperatingLogApi {

	@ApiOperation("查看系统操作日志")
	@GetMapping("list")
	RespVo<Object> getLogList(Pager page) throws BusinessException;

}
