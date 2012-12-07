package com.ndli.smartsbourg.tasks;

import java.net.URL;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.ndli.smartsbourg.R;

public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {

	private Bitmap bitmap;
	private Resources resources;
	private IImageLoadTaskDelegate delegate;
	String urlString;

	public ImageLoadTask(Bitmap bitmap, Resources resources, IImageLoadTaskDelegate delegate) {
		this.bitmap = bitmap;
		this.resources = resources;
		this.delegate = delegate;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		
		urlString = params[0];
	    boolean result = false;

	    try {
	    	URL url = new URL(urlString);

    		Log.d("smbg", "Decode : " + urlString);
	        bitmap = BitmapFactory.decodeStream(url.openStream());

    		Log.d("smbg", "Decoded : " + urlString);
	    } catch (Exception e) {
	        Log.e("smbg", "Could not load Bitmap from: " + urlString);

	        bitmap = BitmapFactory.decodeResource(resources, R.drawable.default_img);
	    }

		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap bitmap) {
		this.delegate.onLoadBitmap(bitmap, urlString);
	}
}
