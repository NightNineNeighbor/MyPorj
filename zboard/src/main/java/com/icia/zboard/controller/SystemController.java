package com.icia.zboard.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

@Controller
public class SystemController {
	
	// /board/list에 캐시를 적용. spring cache는 hit하면 메소드를 실행하지 않고 메모리의 캐시값을 그대로 뷰로 보낸다
	// 따라서 뷰의 자바스크립트에 오류 메시지가 보내지지 않는다
	// /에 연결된 index.jsp의 자바스크립트가 오류 메시지를 출력한 후 이동시킨다
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/system/error404")
	public String error404(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		return "system/error404";
	}
	
	@GetMapping("/system/msg")
	public String message(HttpServletRequest req, Model model) {
		Map<String,?> map = RequestContextUtils.getInputFlashMap(req);
		String msgs = (String)map.get("msgs");
		model.addAttribute("msgs", msgs);
		return "system/msg";
	}
}
