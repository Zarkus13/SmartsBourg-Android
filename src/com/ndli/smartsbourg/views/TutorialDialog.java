package com.ndli.smartsbourg.views;

import java.util.List;

import com.ndli.smartsbourg.R;
import com.ndli.smartsbourg.activities.SmBgMapActivity;
import com.ndli.smartsbourg.adapters.TutorialItemsAdapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TutorialDialog extends Dialog {

	
	public TutorialDialog(Context context) {
		super(context);
		
		this.setContentView(R.layout.dialog_tutorial);
	}

	
	// GETTERS AND SETTERS 
	
	@Override
	public void show() {
		ViewPager pager = (ViewPager) findViewById(R.id.tutorial_pager);
//		pager.setAdapter(new TutorialItemsAdapter(((SmBgMapActivity) getOwnerActivity()).getSupportFragmentManager()));
		
		super.show();
	}
}
