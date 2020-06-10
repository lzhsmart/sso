package com.dm.sso.service.impl;

import com.dm.sso.mapper.UserMapper;
import com.dm.sso.service.UserService;
import com.dm.sso.vo.UserInfo;
import com.dm.sso.vo.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
 * <p>创建日期：2020年06月10日 11:09</p>
 * <p>类全名：com.dm.sso.service.impl.UserServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service(UserService.BeanName)
public class UserServiceImpl implements UserService
{
	@Resource
	private UserMapper      userMapper;
	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public UserInfo queryUserByUsername(String username)
	{
		return userMapper.queryUserByUsername(username);
	}

	@Override
	public int insertUser(UserInfo userInfo)
	{
		// 加密密码
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userMapper.insertUserInfo(userInfo);
	}

	@Override
	public int setUserRoles(UserRole userRole)
	{
		// 设置权限
		return userMapper.insertUserRoles(userRole);
	}
}
