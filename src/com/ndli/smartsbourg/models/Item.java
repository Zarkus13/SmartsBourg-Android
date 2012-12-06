package com.ndli.smartsbourg.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.android.maps.GeoPoint;

public class Item {

	int id;
	String title;
	String content;
	ArrayList<Integer> tagIds;
	int parentId;
	String date;
	int authorId;
	GeoPoint coordinates;

	public Item(int id, String title, String content, ArrayList<Integer> tagIds, int parentId, String date, int authorId, GeoPoint coordinates) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.tagIds = tagIds;
		this.parentId = parentId;
		this.date = date;
		this.authorId = authorId;
		this.coordinates = coordinates;
	}

	public static Item fromGenericMap(HashMap<String, Object> map) {
		int id = (Integer) map.get("id");
		String title = (String) map.get("title");
		String content = (String) map.get("content");
		String date = (String) map.get("date");
		int parentId = (Integer) map.get("parent_id");
		int authorId = (Integer) map.get("author_id");
		ArrayList<Integer> tagIds = new ArrayList<Integer>();
		Object[] tagsMap = (Object[]) map.get("tags");
		for (int i = 0; i < tagsMap.length; i++) {
			tagIds.add((Integer) tagsMap[i]);
		}

		GeoPoint coors = null;
		Object[] coorsMap = (Object[]) map.get("coordinates");
		coors = new GeoPoint((Integer) coorsMap[0], (Integer) coorsMap[1]);
		return new Item(id, title, content, tagIds, parentId, date, authorId, coors);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public ArrayList<Integer> getTagIds() {
		return tagIds;
	}

	public void setTagIds(ArrayList<Integer> tagIds) {
		this.tagIds = tagIds;
	}

}
