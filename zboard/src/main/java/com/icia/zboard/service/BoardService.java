package com.icia.zboard.service;

import java.security.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.icia.zboard.dao.*;
import com.icia.zboard.util.*;
import com.icia.zboard.vo.*;

import lombok.extern.slf4j.*;

@Service
@Slf4j
public class BoardService {
	@Autowired
	private BoardDao dao;
	@Autowired
	private PagingUtil paging;
	
	@Cacheable(value="list", key="#pageNo")
	public Map<String,Object> list(int pageNo) {
		int numberOfBoard = dao.count();
		Pagination pagination =  paging.getPagination(numberOfBoard, pageNo);
		Map<String,Integer> rowMap = new HashMap<>();
		rowMap.put("startRowNum", pagination.getStartRowNum());
		rowMap.put("endRowNum", pagination.getEndRowNum());
		List<Board> list = dao.list(rowMap);
		Map<String,Object> result = new HashMap<>();
		result.put("pagination", pagination);
		result.put("list", list);
		return result; 
	}
	
	@Transactional(rollbackFor=NullPointerException.class)
	public Board read(int bno) {
		dao.increaseReadCnt(bno);
		return dao.read(bno);
	}
	
	@PreAuthorize("#board.id == authentication.name")
	@CacheEvict(value="list", allEntries=true)
	public int update(Board board) {
		return dao.update(board);
	}
	
	@CacheEvict(value="list", allEntries=true)
	public int write(Board board) {
		return dao.write(board);
	}
	
	// 권한 체크 때문에 bno가 아니라 Board가 필요하다
	@PreAuthorize("#board.id == principal.username or hasRole('ROLE_ADMIN')")
	@CacheEvict(value="list", allEntries=true)
	public int delete(Board board) {
		return dao.delete(board.getBno());
	}

}










