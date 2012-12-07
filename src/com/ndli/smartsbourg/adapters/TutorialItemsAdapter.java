package com.ndli.smartsbourg.adapters;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.fragments.TutorialFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TutorialItemsAdapter extends FragmentStatePagerAdapter {

	public TutorialItemsAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int pos) {
		int id = 0;
		
		switch (pos) {
			case 0:
				id = R.drawable.default_img;
				break;
			case 1:
				id = R.drawable.default_img;
				break;
			case 2:
				id = R.drawable.default_img;
				break;
			case 3:
				id = R.drawable.default_img;
				break;
		}
		
		return new TutorialFragment(id);
	}

	@Override
	public int getCount() {
		return 4;
	}

}
