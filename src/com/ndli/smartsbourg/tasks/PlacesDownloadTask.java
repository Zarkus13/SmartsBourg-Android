package com.ndli.smartsbourg.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.ndli.smartsbourg.activities.SmBgMapActivity;
import com.ndli.smartsbourg.models.Item;
import com.ndli.smartsbourg.utils.DataProvider;
import com.ndli.smartsbourg.utils.JSONParser;

public class PlacesDownloadTask extends AsyncTask<String, Void, Void> {

	Activity a;
	public PlacesDownloadTask(Activity activity) {
		a = activity;
	}

	@Override
	protected Void doInBackground(String... params) {
		String uri = params[0];

		HttpClient client = new DefaultHttpClient();
		HttpGet req = new HttpGet(uri);

		String str = null;
		try {
			HttpResponse resp = client.execute(req);
			str = EntityUtils.toString(resp.getEntity()).replace("\\n", "");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			JSONArray jArray = new JSONArray(str);
			DataProvider.places = new ArrayList<Item>();
			for(int i = 0; i < jArray.length(); i++){
				HashMap<String, Object> itemMap = JSONParser.parse(jArray.getJSONObject(i));
				Item item = Item.fromGenericMap(itemMap);
				DataProvider.places.add(item);
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		Intent intent = new Intent(a, SmBgMapActivity.class);
		a.startActivity(intent);
	}

}
