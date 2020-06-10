package com.dm.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月10日 11:17</p>
 * <p>类全名：com.dm.sso.config.BeanConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
public class BeanConfig
{
	/**
	 * 指定加密方式
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		// 使用BCrypt加密密码
		return new BCryptPasswordEncoder();
	}
}
