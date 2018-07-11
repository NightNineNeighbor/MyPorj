package com.icia.nboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.nboard.vo.Reply;

@Repository
public class ReplyDao {
	@Autowired
	SqlSessionTemplate tpl;
	private static final String MAPPER = "replyMapper.";
	
	public int create(Reply reply) {
		return tpl.insert(MAPPER+"create", reply);
	}
	
	public List<Reply> read(int bno) {
		return tpl.selectList(MAPPER+"read", bno);
	}

	public Reply readOne(int rno, int bno) {
		Map<String, Integer> map = new HashMap<>();
		map.put("rno", rno);
		map.put("bno", bno);
		return tpl.selectOne(MAPPER+"readOne", map);
	}

	public int update(int rno, String content) {
		Map<String, String> map = new HashMap<>();
		map.put("rno", String.valueOf(rno));
		map.put("content", content);
		return tpl.update(MAPPER+"update", map);
	}

	public int delete(int rno) {
		return tpl.delete(MAPPER+"delete", rno);
	}

}
