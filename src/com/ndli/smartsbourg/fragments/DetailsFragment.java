package com.ndli.smartsbourg.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.adapters.MediaAdapter;
import com.ndli.smartsbourg.models.Item;
import com.ndli.smartsbourg.tasks.IImageLoadTaskDelegate;
import com.ndli.smartsbourg.tasks.ImageLoadTask;

public class DetailsFragment extends Fragment implements IImageLoadTaskDelegate {

	private Item item;
	private View mRoot;
	private GridView gallery;
	private TextView text;
	private ImageView imageView;

	public static DetailsFragment newInstance(Item item) {
		DetailsFragment fragment = new DetailsFragment();
		Bundle args = new Bundle();
		args.putSerializable("item", item);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Item item = (Item) getArguments().getSerializable("item");

		mRoot = inflater.inflate(R.layout.fragment_itemdetails, null);
		Button btnDetails = (Button) mRoot.findViewById(R.id.itemdetails_btn_details);
		Button btnMedias = (Button) mRoot.findViewById(R.id.itemdetails_btn_medias);
		Button btnEvents = (Button)mRoot.findViewById(R.id.itemdetails_btn_events);

		gallery = (GridView) mRoot.findViewById(R.id.itemdetails_media);
		text = (TextView) mRoot.findViewById(R.id.itemdetails_txt_content);
		
		TextView titleView = (TextView) mRoot.findViewById(R.id.itemdetails_title);

		text.setText(item.getContent());
		titleView.setText(item.getTitle());
		
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.default_img);
		ImageLoadTask imgLoadTask = new ImageLoadTask(bitmap, getResources(), this);
		
		if(item.getMedias().size() > 0) {
			imgLoadTask.execute(item.getMedias().get(0).getMediaUrl());
		}
		
		imageView = (ImageView) mRoot.findViewById(R.id.itemdetails_image);
		imageView.setImageBitmap(bitmap);
		
		gallery.setAdapter(new MediaAdapter(item.getMedias(), getActivity()));
		
		btnEvents.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});

		btnDetails.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				gallery.setVisibility(View.GONE);
				text.setVisibility(View.VISIBLE);
			}
		});

		btnMedias.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				gallery.setVisibility(View.VISIBLE);
				text.setVisibility(View.GONE);
			}
		});
		return mRoot;
	}

	@Override
	public void onLoadBitmap(Bitmap bitmap, String url) {
		imageView.setImageBitmap(bitmap);
	}

}
