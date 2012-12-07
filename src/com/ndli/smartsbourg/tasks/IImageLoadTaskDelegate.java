package com.ndli.smartsbourg.tasks;

import android.graphics.Bitmap;

public interface IImageLoadTaskDelegate {
	
	public void onLoadBitmap(Bitmap bitmap, String url);
}
