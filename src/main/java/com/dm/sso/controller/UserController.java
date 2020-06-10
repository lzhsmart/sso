package com.dm.sso.controller;

import com.dm.sso.service.UserService;
import com.dm.sso.vo.UserInfo;
import com.dm.sso.vo.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
 * <p>创建日期：2020年06月09日 15:30</p>
 * <p>类全名：com.dm.sso.controller.UserController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestController
public class UserController
{
	@Resource
	private UserService userService;



	@RequestMapping("getuser")
	public UserInfo getUser(@RequestParam String username)
	{
		UserInfo userInfo = userService.queryUserByUsername(username);
		return userInfo;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserInfo userInfo)
	{
		Logger logger = LoggerFactory.getLogger(UserController.class);
		String username = userInfo.getUsername();
		String password = userInfo.getPassword();
		logger.info("用户名：{}，密码：{}", username, password);
		userService.insertUser(userInfo);
		return username + "__" + password;
	}

	@PostMapping("/setRoles")
	public int setUserRoles(@RequestBody UserRole userRole)
	{
		return userService.setUserRoles(userRole);
	}
}
