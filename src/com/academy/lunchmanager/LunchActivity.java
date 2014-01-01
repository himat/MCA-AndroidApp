package com.academy.lunchmanager;

import com.academy.app.R;
import com.academy.app.R.layout;
import com.academy.app.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lunch);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lunch, menu);
		return true;
	}

}
