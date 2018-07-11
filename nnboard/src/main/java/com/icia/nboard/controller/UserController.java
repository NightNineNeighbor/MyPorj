package com.icia.nboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icia.nboard.service.UserService;
import com.icia.nboard.vo.User;

@Controller
public class UserController {
	@Autowired UserService userService;
	@Autowired PasswordEncoder encoder;
	
	@GetMapping("user/main")
	public String main(Model model) {
		model.addAttribute("userList",userService.getAll());
		return "user/main";
	}
	
	@PostMapping("/user/create")
	public String join(String id, String password, String name) {
		userService.create(new User(id, name, encoder.encode(password)));
		return "redirect:main";
	}

	@PostMapping("/user/update")
	public String update(String id, String name) {	//수정 필요
		userService.update(new User(id, name, null));
		return "redirect:main";
	}
	
	@PostMapping("/user/delete")
	public String delete(String id) {
		userService.delete(id);
		return "redirect:main";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

}
