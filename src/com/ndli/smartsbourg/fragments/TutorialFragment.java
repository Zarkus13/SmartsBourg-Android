package com.ndli.smartsbourg.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TutorialFragment extends Fragment {
	
	private int idImage;

	public TutorialFragment(int idImage) {
		super();
		this.idImage = idImage;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		ImageView imageView = new ImageView(getActivity());
		imageView.setImageResource(this.idImage);
		
		return imageView;
	}

	
}
