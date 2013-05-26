package com.qwi.josemi.ticketsRestaurant.dto;

import java.util.List;

public class UserData {

	private String amount;
	private String username;
	private List<Movement> movements;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
}
