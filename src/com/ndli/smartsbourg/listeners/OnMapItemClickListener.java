package com.ndli.smartsbourg.listeners;

import android.app.Fragment;
import android.app.FragmentTransaction;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;
import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.fragments.DetailsFragment;
import com.ndli.smartsbourg.fragments.SmBgMapFragment;
import com.ndli.smartsbourg.models.Item;

public class OnMapItemClickListener implements OnInfoWindowClickListener {

	private SmBgMapFragment smBgMapFragment;
	
	public OnMapItemClickListener(SmBgMapFragment smBgMapFragment) {
		this.smBgMapFragment = smBgMapFragment;
	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		Item item = smBgMapFragment.getMarkersItems().get(marker);
		
		if(LEBOOLEANILESTTROUE) {
			Fragment frag = DetailsFragment.newInstance(item);
			FragmentTransaction trans = smBgMapFragment.getActivity().getFragmentManager().beginTransaction();
			
			trans.replace(R.id.item_details_fragment, frag);
			trans.commit();
		}
	}

}
