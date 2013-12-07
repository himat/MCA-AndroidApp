package com.academy.clubs;

import java.util.ArrayList;

import com.academy.app.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

/**
 * Shows the club homescreen to user 
 * @author Roland
 *
 */
public class ClubActivity extends ListActivity {

	ArrayList<Announcement> feed;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		feed = new ArrayList<Announcement>();
		//*********TEST CASES
		feed.add(new Announcement("Computer Science Club Meeting Today", new Club("Computer Science Club")));
		feed.add(new Announcement("Interstellar Competition", "Bring your calculators!", new Club("Math League")));
		feed.add(new Announcement("Extremely long spammy spam announcment intended to overflow trolololol",
				"spam, spam, spammy spam spam, trolololololol, lolol, loolooooool lwals olozls", new Club("Spam")));
		//*********
		setListAdapter(new FeedAdapter(this, feed));
		//setListAdapter(new ArrayAdapter<Announcement>(ClubActivity.this, android.R.layout.simple_list_item_1, feed));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		//pass the announcement info
		Bundle b  = new Bundle();
		b.putString("title", feed.get(position).getTitle());
		b.putString("body", feed.get(position).getBody());
		b.putString("club", feed.get(position).getClub().getName());
		Intent i = new Intent(ClubActivity.this, FeedInfo.class);
		i.putExtras(b);
		startActivity(i);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.club, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())	{
		case R.id.club_list:
			Intent i = new Intent(ClubActivity.this, ClubListActivity.class);
			startActivity(i);
			break;
		default: break;
		}
		return true;
	}
	
}
