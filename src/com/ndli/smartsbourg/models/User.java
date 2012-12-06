package com.ndli.smartsbourg.models;

import java.util.HashMap;

public class User {

	String email;
	int id;

	public User(String email, int id) {
		this.email = email;
		this.id = id;
	}

	public static User fromGenericMap(HashMap<String, Object> map) {
		int id = (Integer) map.get("id");
		String email = (String) map.get("email");
		return new User(email, id);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
