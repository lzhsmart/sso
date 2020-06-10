package com.dm.sso.mapper;

import com.dm.sso.vo.UserInfo;
import com.dm.sso.vo.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月09日 15:27</p>
 * <p>类全名：com.dm.sso.mapper.UserMapper</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface UserMapper
{
	// 查询用户
	UserInfo queryUserByUsername(String username);

	// 插入用户
	@Insert("insert into user(username, password) value(#{username}, #{password})")
	int insertUserInfo(UserInfo userInfo);

	// 插入用户角色
	@Insert("insert into user_roles(username, role) value(#{username}, #{role})")
	int insertUserRoles(UserRole userRole);
}
