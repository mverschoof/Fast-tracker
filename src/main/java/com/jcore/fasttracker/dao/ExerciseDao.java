package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.jcore.fasttracker.model.Exercise;

@Transactional
public interface ExerciseDao extends CrudRepository<Exercise, Long> {

	public Exercise findByName(String name);

	public Exercise findByUuid(String uuid);

	public List<Exercise> findByUserId(Integer userId);
	
	public List<Exercise> findByTrackUuid(String trackUuid);

	public List<Exercise> findAll();

}