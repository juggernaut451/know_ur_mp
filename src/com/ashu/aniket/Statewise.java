package com.ashu.aniket;

import com.ashu.aniket.SQLiteConnector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Statewise extends Activity {
	
	public static String Statewisesearch;
	ListView liststatewise;
	SQLiteConnector sqlConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statewise);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.statewise, menu);
		return true;
	}

	public void onClickStatewise(View v) {
		 EditText  statewise=(EditText)findViewById(R.id.statewiseText);
		 Statewisesearch=statewise.getText().toString();
		 TextView attendance= (TextView) findViewById(R.id.textView1);
         attendance.setText("NAME");
		 ListView liststatewise = (ListView) findViewById(R.id.statewiselist);
			sqlConnect = new SQLiteConnector(this);

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, sqlConnect.statewise());
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.color, sqlConnect.statewise());
			liststatewise.setAdapter(adapter1);
			
			liststatewise.setOnItemClickListener(new OnItemClickListener() {
		          public void onItemClick(AdapterView<?> parent, View view,
		              int position, long id) {
		        	  
		              // selected item
		              String product = ((TextView) view).getText().toString();
		              Mpbyname.mp1=product;
		            
		             
		              // Launching new Activity on selecting single List Item
		              
		              // sending data to new activity
		            
		           
		              Intent intent = new Intent(getApplicationContext(), showall.class);
		              startActivity(intent); 
							
						}
		          
		        });
			
       }
	
}
