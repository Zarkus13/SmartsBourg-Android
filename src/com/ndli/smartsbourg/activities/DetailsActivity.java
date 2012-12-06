package com.ndli.smartsbourg.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.fragments.DetailsFragment;
import com.ndli.smartsbourg.utils.DataProvider;

public class DetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splashscreen);

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, DetailsFragment.newInstance(DataProvider.places.get(0)));
		ft.commit();
	}

}
