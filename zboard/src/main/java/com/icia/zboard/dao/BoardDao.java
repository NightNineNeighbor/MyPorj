package com.icia.zboard.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.icia.zboard.vo.*;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate tpl;
	
	public int count() {
		return tpl.selectOne("boardMapper.count");
	}
	public List<Board> list(Map map) {
		return tpl.selectList("boardMapper.list", map);
	}
	public void increaseReadCnt(int bno) {
		tpl.update("boardMapper.increaseReadCnt", bno);
	}
	public Board read(int bno) {
		return tpl.selectOne("boardMapper.read", bno);
	}
	public int write(Board board) {
		return tpl.insert("boardMapper.write", board);
	}
	public int update(Board board) {
		return tpl.update("boardMapper.update", board);
	}
	public int delete(int bno) {
		return tpl.delete("boardMapper.delete", bno);
	}
}








