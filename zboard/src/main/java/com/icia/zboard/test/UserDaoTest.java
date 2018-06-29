package com.icia.zboard.test;

import java.util.Date;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.transaction.annotation.*;

import com.icia.zboard.dao.*;
import com.icia.zboard.vo.*;

import lombok.extern.slf4j.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@Slf4j
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	//@Test
	public void idCheckTest() {
		log.info("{}", dao.idCheck("spring"));
	}
	@Test
	// Transaction을 지정. @Test와 같이 사용되면 무조건 rollback
	@Transactional
	public void insertAndReadTest() {
		dao.join(new User("russia", "aaaaa", "bbbbb", null, null, "aaa@a.com", new Date()));
		User user = dao.read("russia");
		log.info("user:{}", user);
	}
}