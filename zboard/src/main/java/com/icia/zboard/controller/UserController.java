package com.icia.zboard.controller;

import java.security.*;
import java.util.*;

import javax.servlet.http.*;
import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.mvc.support.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.icia.zboard.service.*;
import com.icia.zboard.util.*;
import com.icia.zboard.vo.*;

import lombok.extern.slf4j.*;

@Controller
@Slf4j
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private ObjectMapper mapper;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, "birthDate", new DateCustomEditor());
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/user/idCheck")
	public ResponseEntity<String> idCheck(Optional<String> id) throws JsonProcessingException {
		boolean idCheck = service.idCheck(id.orElseThrow(()->new IllegalArgumentException(ZBoard.NEED_ID)));
		return new ResponseEntity<>(mapper.writeValueAsString(idCheck), HttpStatus.OK) ;
	}
	
	@GetMapping("/user/join")
	public String join(Model model) {
		return "user/join";
	}
	@PostMapping("/user/join")
	public String join(@Valid User user, BindingResult result, @RequestParam(required=false) MultipartFile sajin) throws BindException {
		if(result.getErrorCount() > 0)
			throw new BindException(result);
		service.join(user, sajin);
		return "redirect:/board/list";
	}
	
	@GetMapping("/user/read")
	@Secured("IS_AUTHENTICATED_FULLY")
	public String read(Principal principal, Model model) {
		model.addAttribute("user", service.read(principal.getName()));
		return "user/read";
	}
	
	@PostMapping("/user/update")
	@Secured("IS_AUTHENTICATED_FULLY")
	public String update(@Valid User user, BindingResult result) throws BindException {
		if(result.getErrorCount() > 0)
			throw new BindException(result);
		service.update(user);
		return "redirect:/board/list";
	}
	
	@PostMapping("/user/resign")
	@Secured("IS_AUTHENTICATED_FULLY")
	public String resign(Authentication auth, SecurityContextLogoutHandler handler, HttpServletRequest req, HttpServletResponse res) {
		service.resign(auth.getName());
		handler.logout(req, res, auth);
		return "redirect:/board/list";
	}
	
	@GetMapping("/user/findId")
	public String findId(Principal principal, RedirectAttributes ra) {
		log.info("principal: {}", principal);
		if(principal==null)
			return "user/findId";
		ra.addFlashAttribute("msg", ZBoard.ALREADY_LOGIN);
		return "redirect:/";
	}
	@PostMapping("/user/findId")
	public String findId(Optional<String> irum, Optional<String> email, Principal principal, RedirectAttributes ra) {
		boolean result = service.findPwd(irum.orElseThrow(()->new IllegalArgumentException(ZBoard.NEED_IRUM)), 
			email.orElseThrow(()->new IllegalArgumentException(ZBoard.NEED_EMAIL)));
		ra.addFlashAttribute("msg", result? ZBoard.SEND_MAIL: ZBoard.SEND_MAIL_FAILURE);				
		return "redirect:/system/msg";
	}
	
	@GetMapping("/user/findPwd")
	public String findPwd(Principal principal, RedirectAttributes ra) {
		log.info("principal: {}", principal);
		if(principal==null)
			return "user/findPwd";
		ra.addFlashAttribute("msg", ZBoard.ALREADY_LOGIN);
		return "redirect:/";
	}
	@PostMapping("/user/findPwd")
	public String findPwd(Optional<String> id, Optional<String> email, RedirectAttributes ra) {
		boolean result = service.findPwd(id.orElseThrow(()->new IllegalArgumentException(ZBoard.NEED_ID)), 
			email.orElseThrow(()->new IllegalArgumentException(ZBoard.NEED_EMAIL)));
		ra.addFlashAttribute("msg", result? ZBoard.SEND_MAIL: ZBoard.SEND_MAIL_FAILURE);				
		return "redirect:/system/msg";
	}
}