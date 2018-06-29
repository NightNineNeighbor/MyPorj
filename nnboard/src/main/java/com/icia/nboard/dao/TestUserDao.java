package com.icia.nboard.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icia.nboard.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@WebAppConfiguration
public class TestUserDao {
	@Autowired UserDao dao;
	private User user;
	
	@Before
	public void setUp() {
		user = new User("id", "name", "password");
	}

	@Test
	public void SetupTest() {
		assertThat(dao, is(notNullValue()));
	}
	
	@Test
	@Transactional
	public void CRUDTest() {
		dao.create(user);
		user.setName("updated");
		dao.update(user);
		assertThat(dao.read("id").getName().equals("updated"),is(true));
		
		
		dao.delete("id");
		assertThat(dao.read("id"), is(nullValue()));
		
	}
	
}
