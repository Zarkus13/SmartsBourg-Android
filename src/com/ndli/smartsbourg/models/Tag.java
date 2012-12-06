package com.ndli.smartsbourg.models;

import java.util.HashMap;

public class Tag {
	int id;
	String title;

	public Tag(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public static Tag fromGenericMap(HashMap<String, Object> map) {
		int id = (Integer) map.get("id");
		String title = (String) map.get("title");
		return new Tag(id, title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
