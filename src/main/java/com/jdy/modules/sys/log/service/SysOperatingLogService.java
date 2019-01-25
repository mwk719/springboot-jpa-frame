package com.jdy.modules.sys.log.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.jdy.common.annotation.SysLog;
import com.jdy.common.config.exception.BusinessException;
import com.jdy.data.common.dto.Pager;
import com.jdy.data.syslog.decker.SysOperatingLogDecker;
import com.jdy.data.syslog.dto.SysOperatingLog;
import com.jdy.modules.sys.log.api.SysOperatingLogApi;
import com.jdy.vo.resp.RespSysOperatingLogVo;
import com.jdy.vo.resp.RespVo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;

@RestController
@CrossOrigin
public class SysOperatingLogService implements SysOperatingLogApi {

	@Autowired
	SysOperatingLogDecker sysOperatingLogDecker;

	@SysLog(value = "查看系统操作日志")
	@Override
	public RespVo<Object> getLogList(Pager page) throws BusinessException {
		List<SysOperatingLog> list = sysOperatingLogDecker.findAll(page);

		List<RespSysOperatingLogVo> sovlist = new ArrayList<>();
		list.forEach(sysl -> {
			RespSysOperatingLogVo slv = new RespSysOperatingLogVo();
			BeanUtil.copyProperties(sysl, slv);
			slv.setCreateTime(DateUtil.formatDateTime(sysl.getCreateTime()));
			sovlist.add(slv);
		});
		return RespVo.build().success().setPager(page).setBody(sovlist);
	}

}
