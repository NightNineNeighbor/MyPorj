package com.icia.nboard.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icia.nboard.dao.ReplyDao;
import com.icia.nboard.vo.Board;
import com.icia.nboard.vo.Reply;

@RestController
public class RController {
	@Autowired ReplyDao dao;
	@Autowired ObjectMapper mapper;
	
	@RequestMapping(value = "/reply/{bno}", method=RequestMethod.GET)
	public List<Reply> read(@PathVariable("bno") int bno) {
		return dao.read(bno);
	}
	
	@RequestMapping(value = "/reply/{bno}", method=RequestMethod.POST)
	public String create(@PathVariable("bno") int bno, String content, Principal principal) {
		dao.create(new Reply(0, bno, principal.getName(), content));
		return principal.getName()+"'s reply create success";
	}
	
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "rest hello world";
	}
	
	@GetMapping("/jackson")
	public String jackson() throws JsonProcessingException {
		Board board = new Board(3, "writer", "title", "content", new Date(), 32, 24);
		return mapper.writeValueAsString(board);
	}
	
	@GetMapping("/tostring")
	public String tostring() throws JsonProcessingException {
		Board board = new Board(3, "writer", "title", "content", new Date(), 32, 24);
		return board.toString();
	}
	
	@GetMapping("/notjackson")
	public Board notJackson() throws JsonProcessingException {
		Board board = new Board(3, "writer", "title", "content", new Date(), 32, 24);
		return board;
	}

}
