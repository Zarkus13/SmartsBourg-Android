package com.ndli.smartsbourg.utils;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ndli.smartsbourg.models.Item;

public class ListViewItemAdapter extends BaseAdapter {

	ArrayList<Item> items;

	public ListViewItemAdapter(ArrayList<Item> items) {
		super();
		this.items = items;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public Item getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
