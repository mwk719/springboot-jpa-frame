package com.jdy.common.annotation;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jdy.common.dto.TokenUser;
import com.jdy.common.util.IPUtil;
import com.jdy.common.util.TokenUtil;
import com.jdy.sys.log.decker.SysOperatingLogDecker;
import com.jdy.sys.log.dto.SysOperatingLog;
import com.jdy.sys.role.decker.SysRoleDecker;
import com.jdy.sys.role.decker.SysUserDecker;
import com.jdy.sys.role.dto.SysRole;
import com.jdy.sys.role.dto.SysUser;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

	@Autowired
	SysOperatingLogDecker sysOperatingLogDecker;

	@Autowired
	SysUserDecker sysUserDecker;

	@Autowired
	SysRoleDecker sysRoleDecker;

	// 定义切点 @Pointcut
	// 在注解的位置切入代码
	@Pointcut("@annotation( com.jdy.common.annotation.SysLog)")
	public void logPoinCut() {
	}

	// 切面 配置通知
	@AfterReturning("logPoinCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		System.out.println("切面。。。。。");
		// 保存日志
		SysOperatingLog sysLog = new SysOperatingLog();

		// 从切面织入点处通过反射机制获取织入点处的方法
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 获取切入点所在的方法
		Method method = signature.getMethod();

		// 获取操作
		SysLog myLog = method.getAnnotation(SysLog.class);
		if (myLog != null) {
			String value = myLog.value();
			sysLog.setOperation(value);// 保存获取的操作
		}

		// 获取请求的类名
		String className = joinPoint.getTarget().getClass().getName();
		// 获取请求的方法名
		String methodName = method.getName();
		sysLog.setMethod(className + "." + methodName);

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		// 将参数所在的数组转换成json
		String params = JSONUtil.toJsonStr(args);
		sysLog.setParams(params);
		sysLog.setCreateTime(new Date());
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		// 获取token
		String gas = request.getHeader("gasToken");
		TokenUser tu = TokenUtil.decryptTokenUser(gas);
		// 获取用户名
		SysUser su = sysUserDecker.findById(tu.getAdminId());
		if (su == null) {
			sysLog.setUsername("未知用户");
		} else {
			sysLog.setUsername(su.getUsername());
		}
		// 获取用户角色
		SysRole sr = sysRoleDecker.findById(tu.getRoleId());
		if (su == null) {
			sysLog.setRoleName("未知角色");
		} else {
			sysLog.setRoleName(sr.getRole());
		}
		// 获取用户ip地址
		String ip = ServletUtil.getClientIP(request, gas);
		sysLog.setIp(ip);
		// 根据IP获取地址
		sysLog.setAddress(IPUtil.getAddressByIp(ip));
		sysLog.setValid(1);
		// 调用service保存SysLog实体类到数据库
		sysOperatingLogDecker.save(sysLog);
	}

}