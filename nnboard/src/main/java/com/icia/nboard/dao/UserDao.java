package com.icia.nboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.nboard.vo.User;

@Repository
public class UserDao {
	@Autowired
	SqlSessionTemplate tpl;

	public int create(User user) {
		return tpl.insert("userMapper.create", user);
	}

	public User read(String id) {
		return tpl.selectOne("userMapper.read", id);
	}

	public int update(User user) {
		return tpl.update("userMapper.update", user);
	}

	public int delete(String id) {
		return tpl.delete("userMapper.delete", id);
	}
	
	public List<User> getAll(){
		return tpl.selectList("userMapper.getAll");
	}
}
