package com.noahfranck.criminallaw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/*
Goal of the class is to abstract the cod einitally done in CrimeActivity and
put it in here so that it can be the same used for whenever we just need one
fragment.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
	protected abstract Fragment createFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);

		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragment_container);
		if(fragment == null){
			fragment = createFragment();
			fm.beginTransaction()
					.add(R.id.fragment_container, fragment)
					.commit();
		}
	}
}
