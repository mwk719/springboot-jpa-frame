package com.jdy.common.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdy.common.config.TokenHandlerInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	// /**
	// * 配置静态资源
	// */
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	// registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	// super.addResourceHandlers(registry);
	// }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用于排除拦截
		registry.addInterceptor(new TokenHandlerInterceptor()).addPathPatterns("/sys/**")
				.excludePathPatterns("/swagger-ui.html/**")// swagger-ui.html
				.excludePathPatterns("/sys/sysUser/logout") // 退出
				.excludePathPatterns("/sys/sysUser/login/**"); // 登录页
	}
}
