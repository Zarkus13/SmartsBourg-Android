package com.ndli.smartsbourg.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String title;
	String content;
	ArrayList<Integer> tagIds;
	int parentId;
	String date;
	int authorId;
	double lat;
	double lon;
	ArrayList<Media> medias;

	public Item(int id, String title, String content, ArrayList<Integer> tagIds, int parentId, String date, int authorId, double lat, double lon) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.tagIds = tagIds;
		this.parentId = parentId;
		this.date = date;
		this.authorId = authorId;
		this.lat = lat;
		this.lon = lon;
	}

	public static Item fromGenericMap(HashMap<String, Object> map) {
		int id = (Integer) map.get("id");
		String title = (String) map.get("title");
		String content = (String) map.get("content");
		String date = (String) map.get("date");
		double lat = 0;
		double lon = 0;
		try {
			lat = Double.valueOf((String) map.get("latitude"));
			lon = Double.valueOf((String) map.get("longitude"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Item i = new Item(id, title, content, null, 0, date, 0, lat, lon);
		if (map.containsKey("media")) {
			ArrayList<Media> medias = new ArrayList<Media>();
			Object[] media = (Object[]) map.get("media");
			for (Object obj : media) {
				@SuppressWarnings("unchecked")
				HashMap<String, Object> o = (HashMap<String, Object>) obj;
				Media m = Media.fromGenericMap(o);
				medias.add(m);
			}
			i.setMedias(medias);
		}

		return i;
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

	public ArrayList<Media> getMedias() {
		return medias;
	}

	public void setMedias(ArrayList<Media> medias) {
		this.medias = medias;
	}

}
