package com.icia.nboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.nboard.dao.UserDao;
import com.icia.nboard.vo.User;

@Service
public class UserService {
	@Autowired UserDao userDao;
	public int create(User user) {
		return userDao.create(user);
	}

	public User read(String id) {
		return userDao.read(id);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public int delete(String id) {
		return userDao.delete(id);
	}
	
	public List<User> getAll(){
		return userDao.getAll();
	}
}
