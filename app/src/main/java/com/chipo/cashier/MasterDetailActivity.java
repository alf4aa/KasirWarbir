package com.chipo.cashier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.chipo.cashier.fragment.CategoryListFragment;
import com.chipo.cashier.fragment.ProductListFragment;
import com.chipo.cashier.fragment.UserListFragment;
import com.chipo.cashier.utils.Constants;


public class MasterDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_master_detail);


		if (savedInstanceState == null) {

			setScreen(getIntent().getStringExtra(MasterDetailFragment.ARG_ITEM_ID));
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			navigateUpTo(new Intent(this, MasterListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
