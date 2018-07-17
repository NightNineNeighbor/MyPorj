package com.icia.nboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int readCntUp(int bno) {
		return tpl.update("boardMapper.readCntUp",bno);
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
	public List<Board> specificRead(int startRowNum, int endRowNum){
		Map<String, Integer> map = new HashMap<>();
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		return tpl.selectList("boardMapper.specificRead",map);
	}
	public int count() {
		return tpl.selectOne("boardMapper.count");
	}
	public String wasLikeUp(Map<String, String> map) {
		return tpl.selectOne("boardMapper.wasLikeUp", map);
	}
	public int putLikeUpList(Map<String, String> map) {
		return tpl.insert("boardMapper.putLikeUpList", map);
	}
	public int likeCntUp(int bno) {
		return tpl.update("boardMapper.likeCntUp",bno);
	}
}
