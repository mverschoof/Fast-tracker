package com.jcore.fasttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "badge", catalog = "fasttracker")
public class Badge {

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	// For example; Spring 5, Java 9, Java 9, etc
	@Column(name = "SUBJECT", nullable = false)
	private String subject;

	// For example; background image or background shape and/or color
	// Not sure what to do with this yet...
	@Column(name = "BACKGROUND", nullable = false)
	private int background;

	// For example; 1 = gold, 2 = silver, 3 = bronze, null = no levels available
	// Could also be done in Strings
	@Column(name = "LEVEL")
	private int level;

	// For example; 1 = high (Spring?), 2 = medium (OCP?), 3 = low (OCA?)
	// Could also be done in Strings
	private int difficulty;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBackground() {
		return this.background;
	}

	public void setBackground(int background) {
		this.background = background;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setBadge(String subject) {
		this.subject = subject;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}
