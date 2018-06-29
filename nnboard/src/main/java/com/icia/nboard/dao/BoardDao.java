package com.icia.nboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.nboard.vo.Board;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate tpl;
	
	public int create(Board board) {
		return tpl.insert("boardMapper.create",board);
	}
	public Board read(int bno) {
		return tpl.selectOne("boardMapper.read",bno);
	}
	public int update(Board board) {
		return tpl.update("boardMapper.update",board);
	}
	public int delete(int bno) {
		return tpl.delete("boardMapper.delete",bno);
	}
	public List<Board> getAll(){
		return tpl.selectList("boardMapper.getAll");
	}
}
