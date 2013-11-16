package com.academy.app;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView activityList; //A reference to the ListView Widget in our main xml file that will display the info
	private String[] activities; //to store all the different activity names to display in our list view
	
	//We can't directy connect the string array to the ListView
	//So this adapter will handle the communication
	private ArrayAdapter<String> listAdapter; 

	//Called automatically by Android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //********************************
        //If you are testing, your activity, uncomment the next line 
        //
        //********************************
        setContentView(R.layout.activity_main);//initializes the screen to our xml file found in res/layout/
        
        activityList = (ListView)findViewById(R.id.activitylist);//Getting and storing the reference to the view from the xml
        
        activities = new String[]{"FSA Calculator", "Activity2", "Activity3"};//Initialize the array of activity names
        
        
        //Connects our string array with the adapter
        //android.R.layout.simple_list_item_1 tells adapter to display items in the ListView 
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        
        activityList.setAdapter(listAdapter);//connects our adapter with the ListView widget that is displayed to the user
        
        
        //This method will handle what to do when a list item is clicked
        //Instead of creating the OnItemClickListener here, it will be made in its own class
        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	
        	//Overriding the default click method which does nothing
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		
        		String item = (String) parent.getItemAtPosition(position);
        		Log.v("list item clicked", item);//Outputs which item was clicked to the LogCat
        		Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();//Displays clicked item on screen
        	}

        	
		});
    }


    //Built-in method that is automatically called by the system
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
