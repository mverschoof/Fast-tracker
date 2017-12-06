package com.jcore.fasttracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.jcore.fasttracker.model.Track;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface TrackDao extends CrudRepository<Track, Long> {

	public Track findByName(String name);

	public Track findByUuid(String uuid);

	public List<Track> findAll();

}
