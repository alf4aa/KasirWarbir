package com.chipo.cashier;

import com.chipo.cashier.fragment.CategoryListFragment;
import com.chipo.cashier.fragment.ProductListFragment;
import com.chipo.cashier.fragment.UserListFragment;
import com.chipo.cashier.utils.Constants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public class MasterListActivity extends FragmentActivity implements
		MasterListFragment.Callbacks {

	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_master_list);

		if (findViewById(R.id.master_detail_container) != null) {

			mTwoPane = true;

			((MasterListFragment) getFragmentManager().findFragmentById(
					R.id.master_list)).setActivateOnItemClick(true);
			
			setScreen("1");
		}

	}

	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {

			setScreen(id);
		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, MasterDetailActivity.class);
			detailIntent.putExtra(MasterDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
	
	private void setScreen(String id)
	{
		while (getSupportFragmentManager().getBackStackEntryCount() > 0){
		    getSupportFragmentManager().popBackStackImmediate();
		}
		
		Bundle arguments = new Bundle();
		arguments.putString(Constants.ARG_ITEM_ID, id);
		
		Fragment fragment  = new UserListFragment();
		String tag = "";
		
		if(id.equals("1"))
			fragment = new UserListFragment();
		else if(id.equals("2"))
			fragment = new CategoryListFragment();
		else if(id.equals("3"))
			fragment = new ProductListFragment();
	
		fragment.setArguments(arguments);
		getSupportFragmentManager()
		.beginTransaction()
		.setTransition(android.R.anim.fade_in)
		.replace(R.id.master_detail_container, fragment,tag)
		.commit();
	}
}
