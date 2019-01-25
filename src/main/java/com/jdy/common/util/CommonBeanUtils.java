package com.jdy.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

/**
 * 重写--防止实际使用中null覆盖有效value的问题
 * 
 * @author 闵渭凯
 *
 *         2018年8月20日
 */
public abstract class CommonBeanUtils extends org.springframework.beans.BeanUtils {

	/**
	 * 对象赋值
	 * 
	 * @param source
	 *            前端传来的
	 * @param target
	 *            数据库查出来的
	 * @throws BeansException
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							Type targetParameterType = writeMethod.getGenericParameterTypes()[0];
							// 特殊类型不再执行copy XMLGregorianCalendar
							if (!(targetParameterType.equals(XMLGregorianCalendar.class))) {
								if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
									writeMethod.setAccessible(true);
								}
								writeMethod.invoke(target, value);
							}
						}
					} catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}
}
