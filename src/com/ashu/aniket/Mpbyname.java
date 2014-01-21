package com.ashu.aniket;

import java.util.ArrayList;
import java.util.List;

import com.ashu.aniket.R;





import android.R.string;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Mpbyname extends Activity {
	
	SQLiteConnector sqlConnect;
public static String mpnamesearch;
public static String mp1;



	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mpbyname);
		
		
		
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mpbyname, menu);
		return true;
	}
	
	
	
	
	
	 public void onClickMpName(View v) {
		
		 TextView mpname= (TextView) findViewById(R.id.textView3);
			mpname.setText("NAME");
		 EditText  mpname1=(EditText)findViewById(R.id.mpname);
		 mpnamesearch=mpname1.getText().toString();
			System.out.print(mpnamesearch);
		 ListView listmpbyname = (ListView) findViewById(R.id.listView1);
			sqlConnect = new SQLiteConnector(this);
			Log.d("AISI",Mpbyname.mpnamesearch);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, sqlConnect.mpname());
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.color, sqlConnect.mpname());
			listmpbyname.setAdapter(adapter1);
		
			listmpbyname.setOnItemClickListener(new OnItemClickListener() {
		          public void onItemClick(AdapterView<?> parent, View view,
		              int position, long id) {
		        	  
		              // selected item
		              String product = ((TextView) view).getText().toString();
		              mp1=product;
		            
		             
		              // Launching new Activity on selecting single List Item
		              
		              // sending data to new activity
		            
		           
		              Intent intent = new Intent(getApplicationContext(), showall.class);
		              startActivity(intent); 
							
						}
		          
		        });
	 
	 }
	
	}