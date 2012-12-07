package com.ndli.smartsbourg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.tasks.PlacesDownloadTask;

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

		/*
		 * Intent intent = new Intent(getActivity(), SmBgMapActivity.class);
		 * startActivity(intent);
		 */

		return v;
	}

}
