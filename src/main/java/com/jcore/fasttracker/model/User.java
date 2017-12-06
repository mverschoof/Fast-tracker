package com.jcore.fasttracker.model;

import java.util.List;

import javax.persistence.*;

public class User {

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String username;

	@Column(name = "PASSWORD", unique = true, nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="FASTTRACK_ID")
	private Track track;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "track",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<TrackItem> completedTrainingSessions;

	// FIXME: link tabel met resultaten?
	// Bijvoorbeeld voor:
	// >= 90%: gold
	// < 90% && > 80%: silver
	// > 65%: bronze
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "track",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Certification> completedCertifications;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Badge> ribbons;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
}