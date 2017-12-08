package com.jcore.fasttracker.model;

import javax.persistence.*;

@MappedSuperclass
public class TrackItem extends Target {

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="FASTTRACK_ID")
	private Track track;

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
}