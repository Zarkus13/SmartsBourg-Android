package com.ndli.smartsbourg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.models.Item;

public class DetailsFragment extends Fragment {

	Item item;
	private View mRoot;
	Gallery gallery;
	TextView text;

	public static DetailsFragment newInstance(Item item) {
		DetailsFragment fragment = new DetailsFragment();
		Bundle args = new Bundle();
		args.putSerializable("item", item);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mRoot = inflater.inflate(R.layout.fragment_itemdetails, null);
		Button btnDetails = (Button) mRoot.findViewById(R.id.itemdetails_btn_details);
		Button btnMedias = (Button) mRoot.findViewById(R.id.itemdetails_btn_medias);

		gallery = (Gallery) mRoot.findViewById(R.id.itemdetails_media);
		text = (TextView) mRoot.findViewById(R.id.itemdetails_txt_content);

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

}
