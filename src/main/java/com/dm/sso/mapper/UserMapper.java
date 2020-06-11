package com.dm.sso.mapper;

import com.dm.sso.vo.UserInfo;
import com.dm.sso.vo.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
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
	/**
	 * 查询所有用户
	 * @return
	 */
	@Select("select * from user")
	List<UserInfo> queryAllUsers();

	/**
	 * 查询用户
	 * @param username
	 * @return
	 */
	UserInfo queryUserByUsername(String username);

	/**
	 * 插入用户
	 * @param userInfo
	 * @return
	 */
	@Insert("insert into user(username, password) value(#{username}, #{password})")
	int insertUserInfo(UserInfo userInfo);

	/**
	 * 设置用户角色
	 * @param userRole
	 * @return
	 */
	@Insert("insert into user_roles(username, role) value(#{username}, #{role})")
	int insertUserRoles(UserRole userRole);
}
