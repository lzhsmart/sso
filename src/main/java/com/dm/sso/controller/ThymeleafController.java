package com.dm.sso.controller;

import com.dm.sso.vo.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
 * <p>创建日期：2020年06月08日 17:38</p>
 * <p>类全名：com.dm.sso.controller.ThymeleafController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Controller
public class ThymeleafController
{
	@RequestMapping("/")
	public String index(Model model, HttpServletResponse response)
	{
		return "/home";
	}

	@RequestMapping("/sample")
	public String sample(Model model)
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("username", username);
		model.addAttribute("userInfo", getUser());
		List<UserInfo> users = new ArrayList<>();
		// users.add(new User("zhangsan"));
		// users.add(new User("wangjingjing", "女", new Date()));
		// users.add(new User("limeimei", "女", new Date()));
		// users.add(new User("lisi", "男", new Date()));
		// model.addAttribute("users", users);
		return "/sample";
	}

	/**
	 * 构造一个user对象
	 * */
	private UserInfo getUser()
	{
		// User user = new User("smart");
		// return user;
		return new UserInfo();
	}
}
