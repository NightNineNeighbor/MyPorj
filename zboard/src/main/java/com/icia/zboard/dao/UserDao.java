package com.icia.zboard.dao;


import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.icia.zboard.vo.*;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate tpl;

	public Optional<String> idCheck(String id) {
		return Optional.ofNullable(tpl.selectOne("userMapper.idCheck", id));
	}
	
	public void join(User user) {
		tpl.insert("userMapper.join", user);
	}
	
	public void authorityForJoin(String id) {
		tpl.insert("userMapper.authorityForJoin", id);
	}

	public User read(String id) {
		return tpl.selectOne("userMapper.read", id);
	}

	public int update(User user) {
		return tpl.update("userMapper.update", user);
	}

	public Optional<String> findId(Map map) {
		return Optional.ofNullable(tpl.selectOne("userMapper.findId", map));
	}
	
	public Optional<String> findPwd(Map map) {
		return Optional.ofNullable(tpl.selectOne("userMapper.findPwd", map));
	}

	public void deleteUser(String id) {
		tpl.delete("userMapper.deleteUser", id); 
		
	}

	public int deleteAuthority(String id) {
		return tpl.delete("userMapper.deleteAuthority", id); 
	}
}
