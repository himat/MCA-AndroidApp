package com.academy.clubs;

import java.util.ArrayList;

import com.academy.app.R;
import com.academy.app.R.layout;
import com.academy.app.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClubListActivity extends ListActivity {

	ArrayList<Club> clubs;//list of clubs user is part of... unless user has a built in arraylist
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		clubs = new ArrayList<Club>();
		//**********TEST CODE
		clubs.add(new Club("Computer Science Club"));
		clubs.get(0).setDesc("A wonderful club all about computer science. Please join ^_^");
		clubs.add(new Club("Math League"));
		clubs.get(1).setDesc("Want to become the best mathematician in the world?  Join the Math League!!!!");
		//**********
		//This is a list, so simple list (change later to accomodate more info... like images):
		setListAdapter(new ArrayAdapter<Club>(ClubListActivity.this, android.R.layout.simple_list_item_1, clubs));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.club_list, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		//pass the club info
		Bundle b  = new Bundle();
		b.putString("title", clubs.get(position).getName());
		b.putString("desc", clubs.get(position).getDesc());
		//TODO pass member list and whatever other items need to be passed
		Intent i = new Intent(ClubListActivity.this, ClubViewActivity.class);
		i.putExtras(b);
		startActivity(i);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())	{
		case R.id.join_club:
			Intent i = new Intent(ClubListActivity.this, JoinClubActivity.class);
			startActivity(i);
			break;
		default: break;
		}
		return true;
	}
}
