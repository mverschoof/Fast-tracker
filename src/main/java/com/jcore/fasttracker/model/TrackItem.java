package com.jcore.fasttracker.model;

import javax.persistence.*;

@Entity
@Table(name = "trackitem", catalog = "fasttracker")
public class TrackItem extends Target {

	@Column(name = "HOMEWORK", nullable = true)
	protected String homework;

	public String getHomework() {
		return this.homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}
}