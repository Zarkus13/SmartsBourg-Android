package com.ndli.smartsbourg.fragments;

import com.ndli.smartsbourg.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {

	public static MapFragment newInstance() {
		MapFragment fragment = new MapFragment();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_map, null);
		
		return v;
	}
	
	
}
