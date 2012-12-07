package com.ndli.smartsbourg.models;

import java.util.HashMap;

public class Media {

	int itemId;
	int authorId;
	String name;
	String description;
	String mediaUrl;

	public Media(String name, String description, String mediaUrl) {
		super();
		this.name = name;
		this.description = description;
		this.mediaUrl = mediaUrl;
	}

	public static Media fromGenericMap(HashMap<String, Object> map) {
		String name = (String) map.get("name");
		String description = (String) map.get("description");
		String mediaUrl = (String) map.get("media_url");
		return new Media(name, description, mediaUrl);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

}
