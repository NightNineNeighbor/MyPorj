package com.icia.nboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.nboard.dao.BoardDao;
import com.icia.nboard.vo.Board;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public int create(Board board) {
		return boardDao.create(board);
	}
	public Board read(int bno) {
		return boardDao.read(bno);
	}
	public int update(Board board) {
		return boardDao.update(board);
	}
	public int delete(int bno) {
		return boardDao.delete(bno);
	}
	public List<Board> getAll(){
		return boardDao.getAll();
	}
	

}
