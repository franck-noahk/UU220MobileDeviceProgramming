package com.noahfranck.criminallaw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends SingleFragmentActivity {
/*  OLD METHOD BEFORE ABSTRACTION
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fragment);

		FragmentManager fm = getSupportFragmentManager();   //getting a fragment manager

		Fragment manager is called because you want to use the suppoort libarray an the
		appCompactActivity class.
		To not use the support the library, then you would subclass Activity and call
		getFragmentManager()

		Fragment Manager maintains a back stack of fragment transactions for navigation.



		Fragment fragment = fm.findFragmentById(R.id.fragment_container);
		if(fragment == null){
			fragment = new CrimeFragment(); // Asking to retrieve CrimeFragmenent from the manager
											// by the view id
			fm.beginTransaction()       //Fragment transactions are used to add, remove , attach,
										// detach, or replace fragments in the fragment list
										//beginTransaction method creates and returns an instance
										// of FragementTransaction. This links them together.
					.add(R.id.fragment_container, fragment)
					//Bread and butter of the transaction, 2 paramiters,
					//container view id and the
					//new CrimeFragment. The view ID is the resource id of the
					 //FrameLayout that we
					//defined in activity_fragmentent.xml
					.commit();
		}   //The if statement says that We need to create fragment transaction, include one add
			// operation in it and then commit it


*/


	//New Way of doing things with abstraction.
	@Override
	protected Fragment createFragment(){
		return new CrimeFragment();


	}
}
