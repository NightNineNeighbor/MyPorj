package com.icia.zboard.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import lombok.extern.slf4j.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@Slf4j
public class UserControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mvc;	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	//@Test
	public void idCheckTest() throws Exception {
		MvcResult mvcResult 
			= mvc.perform(post("/user/idCheck").param("id","spring")).andReturn();
		// 서버의 @ResponseBody 응답을 response 객체에서 꺼낸다
		String result = mvcResult.getResponse().getContentAsString();
		assertThat(result, is("false"));
	}
	/*
	 	hibernate-validator가 서버를 켜서 join하면 동작하지만 테스트로는 동작안함.
	 	아래의 의존성 추가
	 	<dependency>
    		<groupId>org.glassfish</groupId>
    		<artifactId>javax.el</artifactId>
    		<version>3.0.0</version>
		</dependency>
	 */
	@Test
	public void BindingExceptionTest() throws Exception {
		mvc.perform(post("/user/join").param("irum","홍길동"));
	}
}






