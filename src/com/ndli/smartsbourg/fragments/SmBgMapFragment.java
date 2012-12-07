package com.ndli.smartsbourg.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class SmBgMapFragment extends MapFragment {

	public static SmBgMapFragment newInstance() {
		SmBgMapFragment fragment = new SmBgMapFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		getMap().setMyLocationEnabled(true);
		
		LatLng pos = new LatLng(48.58308, 7.747997);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 18);
		
		getMap().moveCamera(update);
	}
}
