package com.academy.clubs;

import com.academy.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FeedInfo extends Activity	{

	TextView title;
	TextView club;
	TextView body;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_info);
		title = (TextView) findViewById(R.id.dialog_title);
		body = (TextView) findViewById(R.id.dialog_body);
		club = (TextView) findViewById(R.id.dialog_clubname);

		Bundle b = getIntent().getExtras();
		title.setText(b.getString("title"));
		body.setText("\t" + b.getString("body"));
		club.setText("--" + b.getString("club"));
		
	}

}
