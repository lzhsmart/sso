package com.dm.sso.config;

import com.dm.sso.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月08日 15:39</p>
 * <p>类全名：com.dm.sso.config.WebSecurityConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Resource
	private CustomUserDetailsService userDatailService;
	@Resource
	private PasswordEncoder          passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/home","/").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().permitAll()
				.and()
				.logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
				.userDetailsService(userDatailService)
				.passwordEncoder(passwordEncoder);
		/*
		auth.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder())
				.withUser("admin").password(passwordEncoder().encode("111111"))
				.roles("ADMIN","USER")
				.and()
				.withUser("user").password(passwordEncoder().encode("123456"))
				.roles("USER");
		*/
	}
}
