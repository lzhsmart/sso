package com.dm.sso.service.impl;

import com.dm.sso.service.UserService;
import com.dm.sso.vo.Role;
import com.dm.sso.vo.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * <p>标题：自定义userDetailsService</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月10日 11:25</p>
 * <p>类全名：com.dm.sso.service.impl.CustomUserDetailsService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Resource
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// 通过用户名从数据库获取用户信息
		UserInfo userInfo = userService.queryUserByUsername(username);
		if (userInfo == null)
		{
			throw new UsernameNotFoundException("用户不存在");
		}
		// 得到用户角色
		List<Role> roles = userInfo.getRoles();
		// 角色集合
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles)
		{
			// 角色必须以`ROLE_`开头，数据库中没有，则在这里加
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new User(userInfo.getUsername(), userInfo.getPassword(), authorities);
	}
}
