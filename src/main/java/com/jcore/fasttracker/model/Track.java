package com.jcore.fasttracker.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "track", catalog = "fasttracker")
public class Track extends Target {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fasttrack",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<User> users;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fasttrack",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<TrackItem> trackItems;

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		if (!this.users.contains(user)) {
			this.users.add(user);
		}
	}

	public void removeUser(User user) {
		if (this.users.contains(user)) {
			this.users.remove(user);
		}
	}

	public User getUserByUsername(String username) {
		if (this.users == null || this.users.isEmpty()) {
			return null;
		}

		for (User user : this.users) {
			if (username.equals(user.getUsername())) {
				return user;
			}
		}

		return null;
	}

	public List<TrackItem> getTrackItems() {
		return this.trackItems;
	}

	public void setTrackItems(List<TrackItem> trackItems) {
		this.trackItems = trackItems;
	}

	public void addTrackItem(TrackItem trackItem) {
		if (!this.trackItems.contains(trackItem)) {
			this.trackItems.add(trackItem);
		}
	}

	public void removeTrackItem(TrackItem trackItem) {
		if (this.trackItems.contains(trackItem)) {
			this.trackItems.remove(trackItem);
		}
	}

	public TrackItem getTrackItemByUuid(String uuid) {
		if (this.trackItems == null || this.trackItems.isEmpty()) {
			return null;
		}

		for (TrackItem item : this.trackItems) {
			if (uuid.equals(item.getUuid())) {
				return item;
			}
		}

		return null;
	}
}