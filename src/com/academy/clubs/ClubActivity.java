package com.academy.clubs;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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
	
}
