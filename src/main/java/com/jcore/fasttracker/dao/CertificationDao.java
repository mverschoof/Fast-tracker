package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.jcore.fasttracker.model.Certification;

@Transactional
public interface CertificationDao extends CrudRepository<Certification, Long> {

	public Certification findByName(String name);

	public Certification findByUuid(String uuid);
	
	public List<Certification> findByFasttrackUuid(String fasttrackUuid);

}
