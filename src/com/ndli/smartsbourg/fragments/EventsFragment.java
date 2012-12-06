package com.ndli.smartsbourg.fragments;

import com.ndli.smartsbourg.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EventsFragment extends Fragment {

	public static EventsFragment newInstance() {
		return new EventsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_events, null);
		ListView list = (ListView) v.findViewById(R.id.events_list);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
