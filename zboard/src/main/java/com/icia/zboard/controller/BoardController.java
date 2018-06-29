package com.icia.zboard.controller;

import java.security.*;
import java.util.*;

import javax.servlet.http.*;
import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import com.icia.zboard.service.*;
import com.icia.zboard.vo.*;

import lombok.extern.slf4j.*;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list")
	public String list(Optional<Integer> pageNo, Model model, HttpServletRequest request) {
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) 
			model.addAttribute("msg", flashMap.get("msg"));
		model.addAttribute("map", service.list(pageNo.orElse(1)));
		return "board/list";
	}
	
	@GetMapping("/board/read")
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public String read(Optional<Integer> bno, Model model, Principal principal) {
		Board board = service.read(bno.orElseThrow(()-> new IllegalArgumentException("bno가 필요합니다")));
		if(board.getId().equals(principal.getName()))
			model.addAttribute("state", "update");
		model.addAttribute("board", board);
		return "board/read";
	}
	
	@GetMapping("/board/write")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public String write(Model model) {
		model.addAttribute("viewName", "board/write");
		return "board/write";
	}
	
	@PostMapping("/board/write")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public String write(@Valid Board board, BindingResult result, Principal principal) throws BindException {
		if (result.getErrorCount() > 0)
			throw new BindException(result);
		board.setId(principal.getName());
		service.write(board);
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/delete")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public String delete(Board board) {
		service.delete(board);
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/update")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public String update(Board board) {
		service.update(board);
		return "redirect:/board/list";
	}
	
}