package com.academy.clubs;

import java.util.ArrayList;

import com.academy.app.R;
import com.academy.app.R.layout;
import com.academy.app.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ClubViewActivity extends Activity {

	TextView title;
	TextView desc;
	ListView memberList;
	ListView announcementList;
	ArrayList<Announcement> announcements;
	//ArrayList<User> users;
	ArrayList<String> tusers;//temp
	Club thisClub;
	
	boolean admin;//if true, then user is an admin and can add/delete members, make announcements, etc.
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_club_view);

		Bundle b = getIntent().getExtras();
		thisClub = new Club(b.getString("title"));
		thisClub.setDesc(b.getString("desc"));
		//TODO set other attributes of club as necessary
		
		admin = false;//TEMPORARILY hardcoded false
		
		announcements = new ArrayList<Announcement>();//TODO put announcements inside club class or something..
		tusers = new ArrayList<String>();
		
		//TEST CODE********
		announcements.add(new Announcement("HELLO WORLD!", "it's a beautiful day", thisClub));
		announcements.add(new Announcement("Nothing", "nothing", thisClub));
		tusers.add("Amih");
		tusers.add("Dnalor");
		tusers.add("Qizar");
		//*****************
		
		memberList = (ListView) findViewById(R.id.member_list);
		announcementList = (ListView) findViewById(R.id.announcement_list);		
		title = (TextView) findViewById(R.id.club_name);
		desc = (TextView) findViewById(R.id.club_desc);

		title.setText(thisClub.getName());
		desc.setText(thisClub.getDesc());
		
		announcementList.setAdapter(new FeedAdapter(this, announcements));
		memberList.setAdapter(new ArrayAdapter<String>(ClubViewActivity.this, android.R.layout.simple_list_item_1, tusers));
		//TODO create adapter for users when user class created?
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.club_view, menu);
		return true;
	}

}
