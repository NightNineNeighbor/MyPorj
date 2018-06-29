package com.icia.zboard.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.*;

import org.hamcrest.core.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import com.icia.zboard.vo.*;

import lombok.extern.slf4j.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@Slf4j
public class BoardControllerTest {
	@Autowired
	// 프레임워크에서 실제로 처리 : 컨테이너. ApplicationContext가 스프링 컨테이너 
	private WebApplicationContext ctx;
	// 요청을 처리해줄 가짜 컨트롤러
	private MockMvc mvc;	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void cacheTest() throws Exception {
		MvcResult result = mvc.perform(get("/board/list").param("pageNo", "1")).andReturn();
		List<Board> list =  (List<Board>)result.getModelAndView().getModel().get("list");
		System.out.println(list);
		System.out.println("====================================================");
		result = mvc.perform(get("/board/list").param("pageNo", "1")).andReturn();
		list =  (List<Board>)result.getModelAndView().getModel().get("list");
		System.out.println(list);
		System.out.println("====================================================");
		result = mvc.perform(get("/board/list").param("pageNo", "1")).andReturn();
		list =  (List<Board>)result.getModelAndView().getModel().get("list");
		System.out.println(list);
		System.out.println("====================================================");
		
	}
	@Test
	public void listTest() throws Exception {
		// /board/list를 pageNo는 1로 실행
		MvcResult result = mvc.perform(get("/board/list").param("pageNo", "1")).andReturn();
		// 서비스에서 보낸 내용이 MvcResult를 이용해 꺼내면 Map이 되어있다
		List<Board> list =  (List<Board>)result.getModelAndView().getModel().get("list");
		assertThat(list.size(), is(not(0)));
		
	}
	@Test
	public void readTest() throws Exception {
		MvcResult result = mvc.perform(get("/board/read").param("bno", "1")).andReturn();
		Board board = (Board)result.getModelAndView().getModel().get("board");
		assertThat(board.getBno(), is(1));
	}
	@Test
	public void writeTest() throws Exception {
		mvc.perform(post("/board/write"));
	}
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(post("/board/delete"));
	}
	@Test
	public void updateTest() throws Exception {
		mvc.perform(post("/board/update"));
	}
}
