package net.skillfullearning.contactslist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContactInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_info, menu);
		return true;
	}

}
