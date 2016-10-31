package com.niit.letzchat.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupInfo {

	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
