package com.ndli.smartsbourg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.utils.DataProvider;
import com.ndli.smartsbourg.utils.ListViewItemAdapter;

public class EventsFragment extends Fragment {

	public static EventsFragment newInstance() {
		return new EventsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_events, null);
		ListView list = (ListView) v.findViewById(R.id.events_list);
		list.setAdapter(new ListViewItemAdapter(DataProvider.currentEvents));

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			}
		});
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
