package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.jcore.fasttracker.model.TrackItem;

@Transactional
public interface TrackItemDao extends CrudRepository<TrackItem, Long> {

	public TrackItem findByName(String name);

	public TrackItem findByUuid(String uuid);
	
	public List<TrackItem> findByFasttrackUuid(String fasttrackUuid);

}
