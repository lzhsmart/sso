package com.dm.sso.aspect;

import java.lang.annotation.*;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月10日 18:47</p>
 * <p>类全名：com.dm.sso.aspect.MyLog</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MyLog
{
	/**
	 * 日志描述信息
	 * @return
	 */
	String description() default "";
}
