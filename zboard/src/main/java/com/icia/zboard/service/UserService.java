package com.icia.zboard.service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.commons.lang3.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;
import com.icia.zboard.dao.*;
import com.icia.zboard.vo.*;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private AsyncService service;
	
	@Value("d:/service/upload")
	private String uploadPath;
	
	public Boolean idCheck(String id) {
		return !dao.idCheck(id).isPresent();
	}
	
	@PostAuthorize("returnObject.id == principal.username")
	public User read(String id) {
		return dao.read(id);
	}
	
	@PreAuthorize("#user.id == principal.username")
	public int update(User user) {
		return dao.update(user);
	}

	@Transactional(rollbackFor=Exception.class)
	public void join(User user, MultipartFile sajin) {
		String encodedPwd = encoder.encode(user.getPwd());
		String originalFileName = sajin.getOriginalFilename();
		String savedFileName = System.currentTimeMillis() + "-" + originalFileName;
		service.fileSave(sajin, savedFileName);
		user.setOriginalFileName(originalFileName);
		user.setSavedFileName(savedFileName);
		user.setPwd(encodedPwd);
		dao.join(user);
		dao.authorityForJoin(user.getId());
	}

	@Transactional(rollbackFor=Exception.class)
	public void resign(String id) {
		dao.deleteUser(id);
		dao.deleteAuthority(id);
	}

	public boolean findId(String irum, String email) {
		Map<String,String> map = new HashMap<>();
		map.put("irum", irum);
		map.put("email", email);
		Optional<String> result = dao.findId(map);
		result.ifPresent((id)->{
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				String text = "<p>아이디를 확인했습니다</p>";
				text += "<p>아이디 : " + id + "</p>";
				text += "로그인 하기 : <a href='http://localhost:8081/zboard/user/login'>클릭하세요</a>";
				messageHelper.setFrom("webmaster@icia.com");
				messageHelper.setTo(email); 							// 받는사람 이메일
				messageHelper.setSubject("비밀번호 변경 메일입니다"); 	// 메일제목. 생략이 가능
				messageHelper.setText(text, true); 						// 메일 내용
				mailSender.send(message);								
			} catch (MessagingException e) {
				e.printStackTrace();
			} 		
		});
		return result.isPresent();
	}
	
	// 자바메일은 메일을 smtp 서버까지발송하는 역할. 메일 발송 실패를 잡아낼 방법은 없다
	public boolean findPwd(String id, String email) throws MailException {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("email", email);
		Optional<String> result = dao.findPwd(map);
		String pwd = RandomStringUtils.random(20);
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			String text = "<p>새로운 비밀번호가 발급되었습니다</p>";
			text += "<p>새로운 비밀번호 : " + pwd + "</p>";
			text += "<p>사용자 보안을 위해 로그인 후 바로 비밀번호를 변경해주시기 바랍니다</p>";
			text += "로그인 하기 : <a href='http://localhost:8081/zboard/user/login'>클릭하세요</a>";
			messageHelper.setFrom("webmaster@icia.com"); 			// 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(email); 							// 받는사람 이메일
			messageHelper.setSubject("비밀번호 변경 메일입니다"); 	// 메일제목. 생략이 가능
			messageHelper.setText(text, true); 						// 메일 내용
			mailSender.send(message);
		} catch(MailException e) {
			e.printStackTrace();
			throw e;
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
		return result.isPresent();
	}

}
