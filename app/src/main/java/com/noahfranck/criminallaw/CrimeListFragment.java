package com.noahfranck.criminallaw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CrimeListFragment extends Fragment {
	private RecyclerView mCrimeRecyclerView;
	private CrimeAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_crime_list,container,
				false);
		mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id
				.crime_recycler_view);
		mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager
				(getActivity()));

		return view;
	}
	/*
	inflate list_item_crime.xml, then immediately pass it into super(). View
	Holder's constructor. THe bvase ViewHolder class will then hold onto the
	fragment_crime_list.xml view hierarchy. If you need that view hierarchy,
	you can find it in ViewHolder's itemView field. (see further pg 173 BNR)
	 */
	private class CrimeHolder extends RecyclerView.ViewHolder{
		public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
			super(inflater.inflate(R.layout.list_item_crime,parent,false));
		}
	}

	//--------------Creating the Adaptor----------------

	private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
		private List<Crime> mCrimes;
		public CrimeAdapter(List<Crime> crimes){
			mCrimes = crimes;
		}

		@NonNull
		@Override
		public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int
				viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			return new CrimeHolder(layoutInflater,parent);
		}

		@Override
		public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i){

		}

		@Override
		public int getItemCount() {
			return mCrimes.size();
		}
	}

	//-----------Setting an Adapter-----------

	private void updateUI(){
		CrimeLab crimeLab = CrimeLab.get(getActivity());
		List<Crime> crimes = crimeLab.getCrimes();

		mAdapter = new CrimeAdapter(crimes);
		mCrimeRecyclerView.setAdapter(mAdapter);
	}
}
