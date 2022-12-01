package com.chipo.cashier;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chipo.cashier.dummy.MasterContent;


public class MasterDetailFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	private MasterContent.DummyItem mItem;

	public MasterDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {

			mItem = MasterContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_master_detail,
				container, false);


		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.master_detail))
					.setText(mItem.content);
		}

		return rootView;
	}
}
