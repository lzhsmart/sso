package com.dm.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月08日 15:17</p>
 * <p>类全名：com.dm.sso.controller.HelloController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestController
@RequestMapping("user")
public class HelloController
{
	@RequestMapping("/hello")
	public String hello(Principal principal)
	{
		return "hello:" + principal.getName();
	}
}
