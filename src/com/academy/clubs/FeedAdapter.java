package com.academy.clubs;

import java.util.ArrayList;

import com.academy.app.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter for feed in ListView in Club Manager
 * @author Roland
 *
 */
public class FeedAdapter extends ArrayAdapter<Announcement> {
	private final Context context;
	private ArrayList<Announcement> announcements;
	
	/**
	 * Constructor for FeedAdapter
	 * @param context Context of Application
	 * @param announcements ArrayList of announcements in feed
	 */
	public FeedAdapter(Context context, ArrayList<Announcement> announcements) {
		super(context, R.layout.announcement_layout, announcements);
		this.announcements = announcements;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.announcement_layout, parent, false);
	
		TextView title = (TextView) rowView.findViewById(R.id.title);
		TextView body = (TextView) rowView.findViewById(R.id.body);
		
		String t = announcements.get(position).getTitle();
		String b = announcements.get(position).getBody();
		//truncate if too long
		if(t.length() > 40)	{
			t = t.substring(0, 40) + "...";
		}
		if(b.length() > 40)	{
			b = b.substring(0, 40) + "...";
		}
		
		title.setText(t);
		body.setText(b);
		
		return rowView;
	}
	
	
}
