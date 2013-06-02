package com.qwi.josemi.ticketsRestaurant.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.qwi.josemi.ticketsRestaurant.dto.Movement;

@Document(collection="users")
public class UserDocument {

	@Id
	private String id;
	private String username;
	private Integer accessNumber;
	private String balance; 
	private List<Movement> movements;
	
	
	public UserDocument() {
		super();
		// TODO Auto-generated constructor stub
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




	public String getBalance() {
		return balance;
	}




	public void setBalance(String balance) {
		this.balance = balance;
	}




	public List<Movement> getMovements() {
		return movements;
	}




	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
}
