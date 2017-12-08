package com.jcore.fasttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "certification", catalog = "fasttracker")
public class Exam extends TrackItem {

	@Column(name = "BADGE", unique = true, nullable = false)
	private Badge badge;

	@Column(name = "REQUIRED_PERCENTAGE", nullable = false)
	private int requiredPercentage;

	public Badge getBadge() {
		return this.badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public int getRequiredPercentage() {
		return this.requiredPercentage;
	}

	public void setRequiredPercentage(int requiredPercentage) {
		this.requiredPercentage = requiredPercentage;
	}

	public boolean isRequiredPercentage(int actualPercentage) {
		return actualPercentage >= this.requiredPercentage;
	}

}