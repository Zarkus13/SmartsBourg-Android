package com.ndli.smartsbourg.fragments;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ndli.smartsbourg.models.Item;
import com.ndli.smartsbourg.utils.DataProvider;

public class SmBgMapFragment extends MapFragment {

	Map<Marker, Item> markersItems;
	
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
		
		markersItems = new HashMap<Marker, Item>();
		
		getMap().setMyLocationEnabled(true);
		
		
		for(Item item : DataProvider.places) {
			MarkerOptions marker = new MarkerOptions()
				.position(new LatLng(item.getLat(), item.getLon()))
				.title(item.getTitle())
				.visible(true);
			
			markersItems.put(getMap().addMarker(marker), item);
		}
		
		LatLng pos = new LatLng(48.58308, 7.747997);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 16);
		
		getMap().moveCamera(update);
	}

	public Map<Marker, Item> getMarkersItems() {
		return markersItems;
	}

	public void setMarkersItems(Map<Marker, Item> markersItems) {
		this.markersItems = markersItems;
	}
}
