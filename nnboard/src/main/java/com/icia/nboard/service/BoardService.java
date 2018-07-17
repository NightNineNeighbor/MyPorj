package com.icia.nboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.nboard.dao.BoardDao;
import com.icia.nboard.util.Pagination;
import com.icia.nboard.util.PagingUtil;
import com.icia.nboard.vo.Board;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	@Autowired
	PagingUtil pagingUtil;
	
	public int create(Board board) {
		return boardDao.create(board);
	}
	
	public Board read(int bno) {
		boardDao.readCntUp(bno);
		return boardDao.read(bno);
	}
	
	public List<Board> specificRead(int startRowNum, int endRowNum){
		return boardDao.specificRead(startRowNum, endRowNum);
	}
	
	public int count() {
		return boardDao.count();
	}
	
	public Map<String,Object> pagedRead(int pageNo) {
		Pagination pagination = pagingUtil.getPagination(boardDao.count(), pageNo);
		
		Map<String,Object> result = new HashMap<>();
		result.put("list", boardDao.specificRead(pagination.getStartRowNum(), pagination.getEndRowNum()));
		result.put("pagination", pagination);
		return result;
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
	
	public boolean likeCntUp(String id, int bno) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("bno", String.valueOf(bno));
		
		boolean flag = false;
		flag = Optional.ofNullable(boardDao.wasLikeUp(map)).orElse("").equals(id);
		
		if(!flag) {
			boardDao.likeCntUp(bno);
			boardDao.putLikeUpList(map);
		}
		return flag;	//true : 좋아요 된 글 , false : 좋아요 되지 않은 글
	}
}
