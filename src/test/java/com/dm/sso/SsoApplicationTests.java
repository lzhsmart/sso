package com.dm.sso;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringRunner.class)
@ContextConfiguration
@WebAppConfiguration
@SpringBootTest
class SsoApplicationTests
{
	@Autowired
	private WebApplicationContext wac;
	private MockMvc               mockMvc;

	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	void contextLoads()
	{
	}

	//查询
	@Test
	public void whenQuerySuccess() throws Exception
	{
		// String result = mockMvc.perform(get("/user")
		// 		.param("username", "jojo")
		// 		.param("age", "18")
		// 		.param("ageTo", "60")
		// 		.param("xxx", "yyy")
		// 		.contentType(MediaType.APPLICATION_JSON_UTF8))
		// 		.andExpect(status().isOk())
		// 		.andExpect(jsonPath("$.length()").value(3)).andReturn().getResponse().getContentAsString();
		// //将服务器返回的json字符串当成变量返回
		// System.out.println(result);
		// //[{"username":null},{"username":null},{"username":null}]
	}
}
