package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.jcore.fasttracker.model.Badge;

@Transactional
public interface BadgeDao extends CrudRepository<Badge, Long> {

	public Badge findByName(String name);
	
	public List<Badge> findBySubject(String subject);

	public List<Badge> findByLevel(int level);

	public List<Badge> findByDifficulty(int difficulty);

	public List<Badge> findAll();
}