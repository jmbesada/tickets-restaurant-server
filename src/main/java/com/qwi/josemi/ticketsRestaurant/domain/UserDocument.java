package com.qwi.josemi.ticketsRestaurant.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class UserDocument {

	@Id
	private String id;
	private String username;
	private Integer accessNumber;
	
	
	public UserDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserDocument(String username, Integer accessNumber) {
		super();
		this.username = username;
		this.accessNumber = accessNumber;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAccessNumber() {
		return accessNumber;
	}
	public void setAccessNumber(Integer accessNumber) {
		this.accessNumber = accessNumber;
	}

	@Override
	public String toString() {
		return "UserDocument [id=" + id + ", username=" + username
				+ ", accessNumber=" + accessNumber + "]";
	}
}
