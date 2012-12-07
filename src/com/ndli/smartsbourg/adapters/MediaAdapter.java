package com.ndli.smartsbourg.adapters;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ndli.smartsbourg.models.Media;
import com.ndli.smartsbourg.tasks.IImageLoadTaskDelegate;
import com.ndli.smartsbourg.tasks.ImageLoadTask;

public class MediaAdapter extends BaseAdapter implements IImageLoadTaskDelegate{
	
	
	HashMap<String, ImageView> viewForUrl;
	ArrayList<Media> medias;
	Context context;
	
	
	

	public MediaAdapter(ArrayList<Media> medias, Context context) {
		super();
		this.medias = medias;
		viewForUrl = new HashMap<String, ImageView>();
		this.context = context;
	}

	@Override
	public int getCount() {
				return medias.size();
	}

	@Override
	public Media getItem(int position) {
				return medias.get(position);
	}

	@Override
	public long getItemId(int position) {
				return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ImageView view = new ImageView(context);
		view.setLayoutParams(new GridView.LayoutParams(150,150));
		Bitmap bmp = null;
		viewForUrl.put(getItem(position).getMediaUrl(), view);
		
		ImageLoadTask task = new ImageLoadTask(bmp, context.getResources(), this);	
		task.execute(getItem(position).getMediaUrl());
		
		return view;
	}

	@Override
	public void onLoadBitmap(Bitmap bitmap, String url) {
			this.viewForUrl.get(url).setImageBitmap(bitmap);
	}

}
