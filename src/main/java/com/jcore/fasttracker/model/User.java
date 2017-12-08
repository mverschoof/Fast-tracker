package com.jcore.fasttracker.model;

import java.util.List;

import javax.persistence.*;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	protected Integer id;

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String username;

	@Column(name = "PASSWORD", unique = true, nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="FASTTRACK_ID")
	private Track track;

	// FIXME: link tabel met resultaten?
	// Bijvoorbeeld voor:
	// >= 90%: gold
	// < 90% && > 80%: silver
	// > 65%: bronze
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "track",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Exam> exams;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Badge> badges;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public void addExam(Exam exam) {
		if (!this.exams.contains(exam)) {
			this.exams.add(exam);
		}
	}

	public void removeExam(Exam exam) {
		if (this.exams.contains(exam)) {
			this.exams.remove(exam);
		}
	}

	public List<Badge> getBadges() {
		return this.badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public void addBadge(Badge badge) {
		if (!this.badges.contains(badge)) {
			this.badges.add(badge);
		}
	}

	public void removeBadge(Badge badge) {
		if (this.badges.contains(badge)) {
			this.badges.remove(badge);
		}
	}

}
