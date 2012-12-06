package com.ndli.smartsbourg.models;

import java.util.HashMap;

public class Media {

	int itemId;
	int authorId;
	String name;
	String description;
	String mediaUrl;

	public Media(int itemId, int authorId, String name, String description, String mediaUrl) {
		super();
		this.itemId = itemId;
		this.authorId = authorId;
		this.name = name;
		this.description = description;
		this.mediaUrl = mediaUrl;
	}

	public static Media fromGenericMap(HashMap<String, Object> map) {
		int itemId = (Integer) map.get("item_id");
		String name = (String) map.get("name");
		String description = (String) map.get("description");
		String mediaUrl = (String) map.get("media_url");
		int authorId = (Integer) map.get("author_id");
		return new Media(itemId, authorId, name, description, mediaUrl);
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
