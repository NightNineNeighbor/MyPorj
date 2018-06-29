package com.icia.nboard.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icia.nboard.vo.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@WebAppConfiguration
public class TestBoardDao {
	@Autowired BoardDao	dao;
	private Board board;
	
	@Before
	public void setUpTest() {
		board = new Board(3, "writer", "title", "content", null, 4, 5);
	}
	
	@Test
	public void setUPTest() {
		assertThat(dao, is(notNullValue()));
	}
	
	@Test
	@Transactional
	public void CRUDTeset() {
		dao.create(board);
		
		List<Board> list = dao.getAll();
		board = list.get(0);
		board.setTitle("updatedTitle");
		board.setContent("updatedContent");
		dao.update(board);
		
		assertThat(dao.read(board.getBno()).getTitle().equals("updatedTitle"),is(true));
	}

}