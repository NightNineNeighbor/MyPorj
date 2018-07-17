package com.icia.nboard.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icia.nboard.service.BoardService;
import com.icia.nboard.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping("/board/create")
	public String create(String title, String content, Principal principal) {
		Board board = new Board();
		board.setWriter(principal.getName());
		board.setTitle(title);
		board.setContent(content);
		boardService.create(board);
		
		return "redirect:main";
	}
	
	@GetMapping("/board/main")
	public String main(Model model, Principal principal) {
		setUsername(model, principal);
		model.addAttribute("list", boardService.getAll());
		return "board/main";
	}
	@GetMapping(path = "/board/articles/{startRowNum}/{endRowNum}")
	public String ariticles(@PathVariable int startRowNum,@PathVariable int endRowNum, Model model) {
		model.addAttribute("list",boardService.specificRead(startRowNum, endRowNum));
		model.addAttribute("articleAmount",boardService.count());
		return "board/articles";
	}
	
	@GetMapping("/board/read")
	public String read(int bno, Model model, Principal principal) {
		setUsername(model, principal);
		model.addAttribute("board",boardService.read(bno));
		return "board/read";
	}
	
	@PostMapping("/board/update")
	public String update(int bno, String title, String content, Principal principal) {
		if(checkOwner(bno, principal.getName())) {
			Board board = new Board();
			board.setBno(bno);
			board.setTitle(title);
			board.setContent(content);
			boardService.update(board);
		}
		return "redirect:main";
	}
	
	@PostMapping("/board/delete")
	public String delete(int bno, Principal principal) {
		if(checkOwner(bno, principal.getName())) {
			boardService.delete(bno);
		}
		return "redirect:main";
	}
	
	private boolean checkOwner(int bno, String writer) {
		return boardService.read(bno).getWriter().equals(writer);
	}
	
	private void setUsername(Model model, Principal principal) {
		model.addAttribute(
				"username",
				Optional.ofNullable(principal).map(Principal::getName)
											  .orElse("ananymous"));
	}
	
	@PostMapping("/board/likeup")
	@Secured({ "ROLE_USER" })
	public String likeUp(int bno, Principal principal, HttpServletRequest req) {
		boardService.likeCntUp(principal.getName(), bno);
		return "redirect:main";
	}
	
	@PostMapping("/board/ajaxlikeup")
	@Secured({ "ROLE_USER" })
	public ResponseEntity<String> ajaxLikeUp(int bno, Principal principal) {
		return new ResponseEntity<>(
				boardService.likeCntUp(principal.getName(), bno)?"wasLiked":"notLiked",
				HttpStatus.OK);
	}
}
