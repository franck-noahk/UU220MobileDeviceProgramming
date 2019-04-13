package com.noahfranck.criminallaw;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Singleton class- only one copy exists, it exists as long as the app is stored
inside of memory,
and if it leaves memory, then it is deleted.

CrimeLab goal is private constructor and public get() method
 */
public class CrimeLab {
	private List<Crime> mCrimes;
	private static CrimeLab sCrimeLab;  //use the 's'CrimeLab to show it is
										// static and not changing
	//Public way to create a Crime Lab, we create the context file later on
	// in chapter 14, of the big nerd ranch book.
	public static CrimeLab get(Context context){
		if(sCrimeLab == null){
			sCrimeLab = new CrimeLab(context);
		}
		return sCrimeLab;
	}

	private CrimeLab(Context context){  //private so no other classes can use
										// this accept for us
		mCrimes = new ArrayList<>();
		//fluffing the arraylist with the beginning so I have dummy values to
		// run.
		for (int i = 0; i < 100; i++){
			Crime crime = new Crime();
			crime.setTitle("Crime #" + i);
			crime.setSolved(i % 2 == 0);
			mCrimes.add(crime);
		}
	}

	public List<Crime> getCrimes(){
		return mCrimes;
	}

	public Crime getCrime(UUID id){
		for (Crime crime : mCrimes){
			if(crime.getID().equals(id)){
				return crime;
			}
		}return null;
	}
}
