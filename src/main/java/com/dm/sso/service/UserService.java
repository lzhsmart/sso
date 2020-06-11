package com.dm.sso.service;

import com.dm.sso.vo.UserInfo;
import com.dm.sso.vo.UserRole;

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
 * <p>创建日期：2020年06月09日 15:29</p>
 * <p>类全名：com.dm.sso.service.UserService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface UserService
{
	String BeanName = "UserService";

	/**
	 * 获取所有用户
	 * @return
	 */
	List<UserInfo> queryAllUsers();

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	UserInfo queryUserByUsername(String username);

	/**
	 * 新增用户
	 * @param userInfo
	 * @return
	 */
	int insertUser(UserInfo userInfo);

	/**
	 * 设置用户角色
	 * @param userRole
	 * @return
	 */
	int setUserRoles(UserRole userRole);
}
