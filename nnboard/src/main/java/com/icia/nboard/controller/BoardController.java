package com.icia.nboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icia.nboard.service.BoardService;
import com.icia.nboard.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/board/create")
	public String create(String title, String content) {
		Board board = new Board();
		board.setWriter("writer");	//수정해라
		board.setTitle(title);
		board.setContent(content);
		boardService.create(board);
		
		return "redirect:main";
	}
	
	@GetMapping("/board/main")
	public String main(Model model) {
		model.addAttribute("list", boardService.getAll());
		return "board/main";
	}
	
	@GetMapping("/board/read")
	public String read(int bno, Model model) {
		model.addAttribute("board",boardService.read(bno));
		return "board/read";
	}
	
	@PostMapping("/board/update")
	public String update(int bno, String title, String content) {
		Board board = new Board();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		boardService.update(board);
		
		return "redirect:main";
	}
	
	@PostMapping("/board/delete")
	public String delete(int bno) {
		boardService.delete(bno);
		
		return "redirect:main";
	}
	
}
