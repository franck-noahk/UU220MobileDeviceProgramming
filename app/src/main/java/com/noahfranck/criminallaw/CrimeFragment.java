package com.noahfranck.criminallaw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeFragment extends Fragment {
	private Crime mCrime;

	@Override
	public void onCreate(Bundle savedINstanceState){
		super.onCreate(savedINstanceState);
		mCrime = new Crime();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_crime,container,false);
		return v;
	}

}
