package com.icia.zboard.test;

import javax.sql.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.web.multipart.*;

import lombok.extern.slf4j.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 화면에 무관한 root-context 설정을 테스트할 것이므로 root-context.xml만 읽어온다
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class SetupTest {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MultipartResolver resolver;
	@Autowired
	DataSource ds;
	@Test
	public void test() {
		log.info("{}", encoder==null);
		log.info("{}", resolver==null);
		log.info("{}", ds==null);
	}
}
