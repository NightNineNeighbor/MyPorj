package com.icia.nboard.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icia.nboard.vo.Reply;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@WebAppConfiguration
public class TestReplyDao {
	@Autowired ReplyDao dao;
	private Reply reply;
	
	@Test
	@Transactional
	public void CRUDTest() {
		reply = new Reply(0, 8888, "writer", "content");
		dao.create(reply);
		
		List<Reply> list = dao.read(8888);
		assertThat(list.size(), is(1));
		
		Reply r1 = list.get(0);		
		Reply r2 = dao.readOne(r1.getRno(), r1.getBno());
		assertThat(r1.equals(r2), is(true));
		
		dao.update(r2.getRno(),"modified content");
		r2 = dao.readOne(r1.getRno(), r1.getBno());
		assertThat(r2.getContent().equals("modified content"), is(true));
		
		dao.delete(r2.getRno());
		assertThat(dao.readOne(r1.getRno(), r1.getBno()), is(nullValue()));
	}
	
}
