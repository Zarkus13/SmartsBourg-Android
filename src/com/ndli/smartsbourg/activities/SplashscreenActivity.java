package com.ndli.smartsbourg.activities;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.fragments.SplashscreenFragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class SplashscreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splashscreen);

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, SplashscreenFragment.newInstance());
		ft.commit();
	}

}
