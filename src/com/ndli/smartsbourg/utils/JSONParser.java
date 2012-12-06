package com.ndli.smartsbourg.utils;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class JSONParser {

	Context context;

	public JSONParser(Context context) {
		super();
		this.context = context;
	}

	public static HashMap<String, Object> parse(String json) {
		HashMap<String, Object> objForKey = new HashMap<String, Object>();

		try {
			JSONObject obj = new JSONObject(json);
			objForKey.putAll(parseObject(obj));
		} catch (Exception e) {
			Log.e("error", e.toString());
		}

		return objForKey;
	}

	public static HashMap<String, Object> parse(JSONObject json) {
		HashMap<String, Object> objForKey = new HashMap<String, Object>();

		try {
			objForKey.putAll(parseObject(json));
		} catch (Exception e) {
			Log.e("error", e.toString());
		}

		return objForKey;
	}

	private static HashMap<String, Object> parseObject(JSONObject obj)
			throws Exception {

		HashMap<String, Object> objForKey = new HashMap<String, Object>();

		String key = "";
		Iterator<?> it = obj.keys();
		while (it.hasNext()) {
			key = (String) it.next();
			if (obj.get(key) instanceof JSONObject) {
				objForKey.put(key, parseObject(obj.getJSONObject(key)));
			} else if (obj.get(key) instanceof JSONArray) {
				objForKey.put(key, parseArray(obj.getJSONArray(key)));
			} else {
				objForKey.put(key, obj.get(key));
			}
		}

		return objForKey;
	}

	private static Object[] parseArray(JSONArray obj) throws Exception {
		Object[] objects = new Object[obj.length()];

		for (int i = 0; i < obj.length(); i++) {
			Object o = obj.get(i);
			if (o instanceof JSONObject) {
				objects[i] = parseObject((JSONObject) o);
			} else if (o instanceof JSONArray) {
				objects[i] = parseArray((JSONArray) o);
			} else {
				objects[i] = o;
			}
		}

		return objects;
	}

}
