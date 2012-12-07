package com.ndli.smartsbourg.tasks;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.ndli.smartsbourg.utils.JSONParser;

import android.os.AsyncTask;

public class PlacesDownloadTask extends AsyncTask<String, Void, Void> {

	@Override
	protected Void doInBackground(String... params) {
		String uri = params[0];

		HttpClient client = new DefaultHttpClient();
		HttpGet req = new HttpGet(uri);

		String str = null;
		try {
			HttpResponse resp = client.execute(req);
			str = EntityUtils.toString(resp.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashMap<String, Object> map = JSONParser.parse(str);
		
		Object[] items = (Object[]) map.get("items");
		

		return null;
	}

}
