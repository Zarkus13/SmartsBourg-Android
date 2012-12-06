package com.ndli.smartsbourg.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.maps.GeoPoint;
import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.activities.SmBgMapActivity;
import com.ndli.smartsbourg.models.Item;
import com.ndli.smartsbourg.utils.DataProvider;

public class SplashscreenFragment extends Fragment {

	public static SplashscreenFragment newInstance() {
		SplashscreenFragment fragment = new SplashscreenFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_splashscreen, null);
		
		ArrayList<Item> places = new ArrayList<Item>();
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		places.add(new Item(0, "item1", "contentlololo", null, 1, "DATE", 1, new GeoPoint(0, 0)));
		
		DataProvider.places = places;
		
		Intent intent = new Intent(getActivity(), SmBgMapActivity.class);
		startActivity(intent);
		
		return v;
	}

}
