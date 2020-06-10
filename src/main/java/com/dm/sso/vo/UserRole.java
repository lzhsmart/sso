package com.dm.sso.vo;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月09日 14:49</p>
 * <p>类全名：com.dm.sso.vo.UserRole</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class UserRole
{
	private int id;
	private int user_id;
	private int role_id;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getRole_id()
	{
		return role_id;
	}

	public void setRole_id(int role_id)
	{
		this.role_id = role_id;
	}
}
