package com.ndli.smartsbourg.activities;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.fragments.SplashscreenFragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class SplashscreenActivity extends Activity {

	public static boolean isTablet = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splashscreen);

		isTablet = findViewById(R.id.tablet) != null;

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, SplashscreenFragment.newInstance());
		ft.commit();
	}

}
