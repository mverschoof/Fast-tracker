package com.jcore.fasttracker.model;

import com.jcore.fasttracker.util.DateTimeUtil;

import java.time.ZonedDateTime;

import javax.persistence.*;

@MappedSuperclass
public class Target {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	protected Integer id;

	@Column(name = "UUID", unique = true, nullable = false, length = 36)
	protected String uuid;

	@Column(name = "NAME", unique = true, nullable = false)
	protected String name;

	@Column(name = "DESCRIPTION", nullable = true)
	protected String description;

	@Column(name = "STARTDATE", nullable = true)
	protected ZonedDateTime startDate;

	@Column(name = "ENDDATE", nullable = false)
	protected ZonedDateTime endDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="FASTTRACK_ID")
	private Track track;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public boolean isStarted() {
		return !DateTimeUtil.isBeforeToday(this.getStartDate());
	}

	public ZonedDateTime getEndDate() {
		return this.endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
		this.endDate = endDate;
	}

	public boolean isEnded() {
		return DateTimeUtil.isAfterToday(this.getEndDate());
	}

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
}