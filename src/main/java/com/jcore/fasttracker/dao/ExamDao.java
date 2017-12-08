package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.jcore.fasttracker.model.Exam;

@Transactional
public interface ExamDao extends CrudRepository<Exam, Long> {

	public Exam findByName(String name);

	public Exam findByUuid(String uuid);

	public List<Exam> findByUserId(Integer userId);
	
	public List<Exam> findByTrackUuid(String fasttrackUuid);

	public List<Exam> findAll();

}