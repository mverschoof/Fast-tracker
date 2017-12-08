package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.jcore.fasttracker.model.User;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByUsername(String name);

	public User findByUuid(String uuid);

	public List<User> findAll();

}