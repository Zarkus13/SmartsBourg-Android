package com.ndli.smartsbourg.fragments;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.activities.SmBgMapActivity;
import com.ndli.smartsbourg.models.Item;
import com.ndli.smartsbourg.tasks.PlacesDownloadTask;
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

		PlacesDownloadTask task = new PlacesDownloadTask();
		task.execute("http://nuit-info-2012.herokuapp.com/items.json");
		
		ArrayList<Item> places = new ArrayList<Item>();
		places.add(new Item(0, "lolilol", "content lolilol", null, 1, null, 0, 48.582058, 7.745864));
		places.add(new Item(1, "pouet", "content pouet", null, 1, null, 0, 48.587055, 7.753938));
		places.add(new Item(2, "lalala", "content lalala", null, 1, null, 0, 48.586516, 7.741922));
		
		DataProvider.places = places;

		Intent intent = new Intent(getActivity(), SmBgMapActivity.class);
		startActivity(intent);

		return v;
	}

}
