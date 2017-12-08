package com.jcore.fasttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcore.fasttracker.dao.UserDao;
import com.jcore.fasttracker.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	public void save(User user) {
		userDao.save(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

}
