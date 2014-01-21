package com.ashu.aniket;

import com.ashu.aniket.R;

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

public class Constituency extends Activity {
	public static String Constituencysearch;
	ListView listconstituency;
	SQLiteConnector sqlConnect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_constituency);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.constituency, menu);
		return true;
	}

	public void onClickConstituency(View v) {
		TextView constituency= (TextView) findViewById(R.id.textView2);
		constituency.setText("NAME");
		 EditText ConstituencyText=(EditText)findViewById(R.id.ConstituencyText);
		Constituencysearch =ConstituencyText.getText().toString();
		listconstituency = (ListView) findViewById(R.id.list_constituency);
			sqlConnect = new SQLiteConnector(this);
		
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, sqlConnect.constituency());
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.color, sqlConnect.constituency());
			listconstituency.setAdapter(adapter1);
			
			listconstituency.setOnItemClickListener(new OnItemClickListener() {
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
